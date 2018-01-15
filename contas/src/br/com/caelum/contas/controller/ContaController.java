package br.com.caelum.contas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	private ContaDAO contaDAO;

	@Autowired
	public ContaController(ContaDAO contaDAO) {
		this.contaDAO = contaDAO;
	}

	@RequestMapping("/formulario")
	public String formulario() {
		return "conta/formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult bindingResult, final RedirectAttributes redirectAttrs) {

		if(bindingResult.hasErrors()) {
			return "conta/formulario";
		}
		
		contaDAO.adiciona(conta);
		redirectAttrs.addFlashAttribute("mensagem", "Conta adicionada com sucesso");
		return "redirect:listaContas";
	}
	
	@RequestMapping("/pagaConta")
	public void paga(Conta conta, HttpServletResponse response) {
		contaDAO.paga(conta.getId());
		response.setStatus(200);
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta, final RedirectAttributes redirectAttrs) {
		contaDAO.altera(conta);
		redirectAttrs.addFlashAttribute("mensagem", "Conta atualizada com sucesso");
		return "redirect:listaContas";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		return new ModelAndView("conta/lista").addObject("contas", contaDAO.lista());
	}
	
	@RequestMapping("/listaContasComModel")
	public String listaComModel(Model model) {
		model.addAttribute("contas", contaDAO.lista());
		return "conta/lista";
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta, final RedirectAttributes redirectAttrs) {
		contaDAO.remove(conta);
		redirectAttrs.addFlashAttribute("mensagem", "Conta removida com sucesso");
		return "redirect:listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public ModelAndView mostra(Conta conta) {
		return new ModelAndView("conta/mostra").addObject("conta", contaDAO.buscaPorId(conta.getId()));
	}
}
