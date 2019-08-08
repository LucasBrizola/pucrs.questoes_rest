package com.questoes.model;

import org.junit.Assert;
import org.junit.Test;

import com.questoes.model.Questao;

public class QuestaoTest {

	@Test
	public void deveCriarUmaQuestaoValida() {
		Questao questao = new Questao("Qual seu nome? ", 1);

		Assert.assertEquals("Qual seu nome? ", questao.getEnunciado());
		Assert.assertEquals(1, questao.getPesquisa());
	}

	
}