package com.questoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questoes.dto.QuestaoDTO;
import com.questoes.model.Questao;
import com.questoes.service.QuestaoService;

@RestController
@RequestMapping(value="questao")
public class QuestaoController {

	private QuestaoService questaoService;
	
	@Autowired
	public QuestaoController(QuestaoService questaoService) {
		this.questaoService = questaoService;
	}
	
	@GetMapping(value="/questao")
	public ResponseEntity<List<QuestaoDTO>> obterPesquisa(@PathVariable("pesquisa") int pesquisa) {
		List<QuestaoDTO> questoes = questaoService.findByPesquisa(pesquisa);
		return new ResponseEntity<List<QuestaoDTO>>(questoes, HttpStatus.OK) ;	}
	
	@GetMapping(value="/questao/{id}")
	public ResponseEntity<Questao> obterQuestaoPorId(@PathVariable("id") int id) {
		Questao questao = questaoService.findById(id);
		return new ResponseEntity<Questao>(questao, HttpStatus.OK) ;
	}
	
	@PostMapping(value="/questao")
	public ResponseEntity<?> salvarQuestao(@RequestBody @Valid QuestaoDTO questaoDTO) {
		this.questaoService.save(questaoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/questao/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
		this.questaoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
