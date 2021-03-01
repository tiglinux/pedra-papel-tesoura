package br.tiagoribeirosantos.pedrapapeltesoura;


/*
    Versão 1.0 do Jogo JokePô desenvolvido em Android JAVA Nativo + XML de minha autoria.

    Desenvolvido por : Tiago Ribeiro Santos
    Email : tiago.programador@hotmail.com
    Date : 26/02/2021
    Site : www.tiagoribeirosantos.6te.net
    WhatsApp: +55 27 9 9601-1693
 */

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView appScore;
    TextView userScore;
    int scoreApp;
    int scoreUser;
    MediaPlayer tesoura,pedra,papel;                     //Objeto de mediaPlayer para player para tocar som


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appScore = findViewById(R.id.appScore);
        userScore = findViewById(R.id.userScore);

        tesoura = MediaPlayer.create(this,R.raw.tesoura);
        pedra = MediaPlayer.create(this,R.raw.pedra);
        papel = MediaPlayer.create(this,R.raw.papel);

    }

    public void selecionadoTesoura(View view) {                                         //Caso user tenha selecionado Tesoura
        this.opcaoSelecionada("TESOURA");
    }

    public void selecionadoPedra(View view) {                                           //Caso user tenha seleciondo Pedra
        this.opcaoSelecionada("PEDRA");
    }

    public void selecionadoPapel(View view) {                                           //Caso user tenha selecionado Papel
        this.opcaoSelecionada("PAPEL");
    }


    public void opcaoSelecionada(String opcaoSelecionada) {                                 //Função que consiste em toda a lógica do jogo do robot através de  opcaoSelecionada por User.
        ImageView imageResultado;
        imageResultado = findViewById(R.id.imageResultado);


        int numero = new Random().nextInt(3);
        String[] opcoes = {"TESOURA", "PEDRA", "PAPEL"};
        String opcoesApp = opcoes[numero];                                                      //Aqui é uma string para armazenar os valores dentro do array escolhida pelo robot

        switch(opcoesApp){                                                                      //Aqui o robot seleciona e mostra a imagem de acordo com a sua escolha.
            case "TESOURA":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            case "PEDRA":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "PAPEL":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            default:
                imageResultado.setImageResource(R.drawable.padrao);
        }


        if (opcaoSelecionada == "TESOURA" && opcoes[numero] == "PEDRA") {
            pedra.start();
            Toast.makeText(this, "Perdeu! Robô ganhou. :/", Toast.LENGTH_SHORT).show();
            scoreApp+= 1;
        } else if (opcaoSelecionada == "TESOURA" && opcoes[numero] == "PAPEL") {
            tesoura.start();                                                                         //Inicia som de tesoura.
            Toast.makeText(this, "Você ganhou! :)", Toast.LENGTH_SHORT).show();
            scoreUser+=1;
        } else if (opcaoSelecionada == "TESOURA" && opcoes[numero] == "TESOURA") {
            Toast.makeText(this, "Empatou! Robô selecionou o mesmo que você!", Toast.LENGTH_SHORT).show();
        } else if (opcaoSelecionada == "PEDRA" && opcoes[numero] == "PAPEL") {
            papel.start();
            Toast.makeText(this, "Perdeu! Robô ganhou. :/", Toast.LENGTH_SHORT).show();
            scoreApp+= 1;
        } else if (opcaoSelecionada == "PEDRA" && opcoes[numero] == "TESOURA") {
            pedra.start();
            Toast.makeText(this, "Você ganhou! :)", Toast.LENGTH_SHORT).show();
            scoreUser+=1;
        } else if (opcaoSelecionada == "PEDRA" && opcoes[numero] == "PEDRA") {
            Toast.makeText(this, "Empatou! Robô selecionou o mesmo que você!", Toast.LENGTH_SHORT).show();
        } else if (opcaoSelecionada == "PAPEL" && opcoes[numero] == "TESOURA") {
            tesoura.start();
            Toast.makeText(this, "Perdeu! Robô ganhou. :/", Toast.LENGTH_SHORT).show();
            scoreApp+= 1;
        } else if (opcaoSelecionada == "PAPEL" && opcoes[numero] == "PEDRA") {
            papel.start();
            Toast.makeText(this, "Você ganhou! :)", Toast.LENGTH_SHORT).show();
            scoreUser+=1;
        } else if (opcaoSelecionada == "PAPEL" && opcoes[numero] == "PAPEL") {
            Toast.makeText(this, "Empatou! Robô selecionou o mesmo que você!", Toast.LENGTH_SHORT).show();
        }

        appScore.setText(scoreApp+"");                                  //Aqui seta o score(placar) do robot App
        userScore.setText(scoreUser+"");

    }


}