package com.questoes.service;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.questoes.dto.QuestaoDTO;
import com.questoes.service.QuestaoService;

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class QuestaoServiceTest {

	@Autowired
	private QuestaoService questaoService;
	
	
	@Test
	public void deveSalvarUmaQuestao() {
		QuestaoDTO questaoParaSalvar = new QuestaoDTO();
		questaoParaSalvar.setId(1);
		questaoParaSalvar.setEnunciado("qual seu nome? ");
		questaoParaSalvar.setResposta("lucas");
		questaoParaSalvar.setPesquisa(1);
		
		questaoService.save(questaoParaSalvar);
		List<QuestaoDTO> questoesSalvas = questaoService.findByPesquisa(1);
		
		Assert.assertEquals(1, questoesSalvas.size());
	
	}
	
}
