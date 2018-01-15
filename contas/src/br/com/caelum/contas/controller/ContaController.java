package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/formulario")
	public String formulario() {
		return "conta/formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta, final RedirectAttributes redirectAttrs) {
		new ContaDAO().adiciona(conta);
		redirectAttrs.addFlashAttribute("mensagem", "Conta adicionada com sucesso");
		return "redirect:listaContas";
	}
	
	@RequestMapping("/alteraConta")
	public String altera(Conta conta, final RedirectAttributes redirectAttrs) {
		new ContaDAO().altera(conta);
		redirectAttrs.addFlashAttribute("mensagem", "Conta atualizada com sucesso");
		return "redirect:listaContas";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		return new ModelAndView("conta/lista").addObject("contas", new ContaDAO().lista());
	}
	
	@RequestMapping("/listaContasComModel")
	public String listaComModel(Model model) {
		model.addAttribute("contas", new ContaDAO().lista());
		return "conta/lista";
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta, final RedirectAttributes redirectAttrs) {
		new ContaDAO().remove(conta);
		redirectAttrs.addFlashAttribute("mensagem", "Conta removida com sucesso");
		return "redirect:listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public ModelAndView mostra(Conta conta) {
		return new ModelAndView("conta/mostra").addObject("conta", new ContaDAO().buscaPorId(conta.getId()));
	}
}
