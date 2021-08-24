package com.everis.msreports.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.msreports.entity.ConsultationPerProduct;
import com.everis.msreports.entity.ReportGeneral;
import com.everis.msreports.entity.credit.CreditCardList;
import com.everis.msreports.entity.credit.ReportCreditCard;
import com.everis.msreports.entity.current.CurrentList;
import com.everis.msreports.entity.current.ReportCurrentAccount;
import com.everis.msreports.entity.customer.Customer;
import com.everis.msreports.entity.fixedTerm.FixedList;
import com.everis.msreports.entity.fixedTerm.ReportFixedAccount;
import com.everis.msreports.entity.saving.ReportSavingAccount;
import com.everis.msreports.entity.saving.SavingList;
import com.everis.msreports.service.ReportService;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/reports")
public class ReportController extends ReportCreditCard{

	@Autowired
	private ReportService service;

	@GetMapping("/general/{id}")
	public Mono<ReportGeneral> reportGeneral(@PathVariable String id) {

		Mono<Customer> customer = service.findCustomerByIdCustomer(id);

		Mono<ReportGeneral> report = customer.flatMap(cus -> service.findCreditCardByIdCustomer(cus.getId())
				.collectList()
				.flatMap(credit -> service.findCurrentAccountByIdCustomer(cus.getId()).collectList()
						.flatMap(current -> service.findSavingAccountByIdCustomer(cus.getId()).collectList()
								.flatMap(saving -> service.findFixedTermByIdCustomer(cus.getId()).collectList()
										.map(fixed -> new ReportGeneral(cus, credit, current, saving, fixed))))));
		return report;
	}

	@PostMapping("/byProduct/CreditCard")
	public Mono<ReportCreditCard> reportForCreditCard(@RequestBody ConsultationPerProduct consulta) {

		return service.findCreditCards()
				.filter(c -> service.isWithInRange(c.getDate(), consulta.getStartDate(), consulta.getEndingDate()))
				.flatMap(cards -> {
					return service.findCreditByIdCreditCard(cards.getId()).collectList()
							.flatMap(credit -> service.FindCreditPayByIdCreditCard(cards.getId()).collectList()
									.map(pays -> new CreditCardList(cards, credit, pays)));
				}).collectList().map(rpt -> new ReportCreditCard(consulta, rpt));
	}
	
	@PostMapping("/byProduct/FixedTerm")
	public Mono<ReportFixedAccount> reportForFixedTerm(@RequestBody ConsultationPerProduct consulta) {

		return service.findFixeds()
				.filter(c -> service.isWithInRange(c.getDate(), consulta.getStartDate(), consulta.getEndingDate()))
				.flatMap(card -> {
					return service.findTransactionFixedByIdFixed(card.getId()).collectList()
									.map(pays -> new FixedList(card, pays));
				}).collectList().map(rpt -> new ReportFixedAccount(consulta, rpt));
	}
	
	@PostMapping("/byProduct/CurrentAccount")
	public Mono<ReportCurrentAccount> reportForCurrentAccount(@RequestBody ConsultationPerProduct consulta) {

		return service.findCurrents()
				.filter(c -> service.isWithInRange(c.getDate(), consulta.getStartDate(), consulta.getEndingDate()))
				.flatMap(card -> {
					return service.findTransactionCurrentByIdCurrent(card.getId()).collectList()
									.map(pays -> new CurrentList(card, pays));
				}).collectList().map(rpt -> new ReportCurrentAccount(consulta, rpt));
	}
	
	@PostMapping("/byProduct/SavingAccount")
	public Mono<ReportSavingAccount> reportForSavingAccount(@RequestBody ConsultationPerProduct consulta) {

		return service.findSavings()
				.filter(c -> service.isWithInRange(c.getDate(), consulta.getStartDate(), consulta.getEndingDate()))
				.flatMap(card -> {
					return service.findTransactionSavingsByIdSaving(card.getId()).collectList()
									.map(pays -> new SavingList(card, pays));
				}).collectList().map(rpt -> new ReportSavingAccount(consulta, rpt));
	}
	
}
