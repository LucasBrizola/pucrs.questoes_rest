package com.questoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questoes.dto.QuestaoDTO;
import com.questoes.model.Questao;
import com.questoes.repository.QuestaoRepository;

@Service
public class QuestaoService {

	private QuestaoRepository questaoRepository;

	@Autowired
	public QuestaoService(QuestaoRepository questaoRepository) {
		this.questaoRepository = questaoRepository;
	}

	public void save(QuestaoDTO questaoDTO) {
		Integer id = questaoDTO.getId();
		String enunciado = questaoDTO.getEnunciado();
		String resposta = questaoDTO.getResposta();
		int pesquisa = questaoDTO.getPesquisa();
		
		Questao questao = new Questao(id, enunciado, resposta, pesquisa);
		this.questaoRepository.saveAndFlush(questao);
	}

	public Questao findById(Integer id) {
		Optional<Questao> questao = questaoRepository.findById(id);
		if (questao.isPresent()) {
			return questao.get();
		}
		throw new ServiceException("Questao não encontrada");
	}

	public List<QuestaoDTO> findAll() {
		List<QuestaoDTO> questaoParaRetorno = new ArrayList<QuestaoDTO>();
		List<Questao> questoes = questaoRepository.findAll();

		for (Questao questao : questoes) {
			QuestaoDTO questaoDTO = criarQuestaoDTO(questao);
			questaoParaRetorno.add(questaoDTO);
		}

		return questaoParaRetorno;
	}

	private QuestaoDTO criarQuestaoDTO(Questao questao) {
		QuestaoDTO questaoDTO = new QuestaoDTO();
		questaoDTO.setId(questao.getId());
		questaoDTO.setEnunciado(questao.getEnunciado());
		questaoDTO.setPesquisa(questao.getPesquisa());
		return questaoDTO;
	}

	public void delete(Integer id) {
		this.questaoRepository.deleteById(id);
	}
	
	public List<QuestaoDTO> findByPesquisa(int pesquisa) {
		List<QuestaoDTO> questoesParaResponder = new ArrayList<QuestaoDTO>();
		List<Questao> questoes = questaoRepository.findByPesquisa(pesquisa);

		for (Questao questao : questoes) {
			QuestaoDTO questaoDTO = criarQuestaoDTO(questao);
			questoesParaResponder.add(questaoDTO);
			return questoesParaResponder;
		}

		throw new ServiceException("Pesquisa não cadastrada");
	}


}