package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/formulario")
	public String formulario() {
		return "conta/formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta) {
		
		new ContaDAO().adiciona(conta);
		
		return "conta/conta-adicionada";
	}
	
	@RequestMapping("listaContas")
	public ModelAndView lista() {
		return new ModelAndView("conta/lista").addObject("contas", new ContaDAO().lista());
	}
	
	@RequestMapping("listaContasComModel")
	public String listaComModel(Model model) {
		model.addAttribute("contas", new ContaDAO().lista());
		return "conta/lista";
	}
}
