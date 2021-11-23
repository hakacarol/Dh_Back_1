package com.haka._mesa_trabalho.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LoteriaService {
    ArrayList<Integer> jogarNumeros() {
        List<Integer> numerosJogo = new ArrayList<>();

        Random random = new Random();

        for (i = 1; 1<=6; i++) {
            numerosJogo.add(random.nextInt(59+1));
        }


        return ;
    }


}
