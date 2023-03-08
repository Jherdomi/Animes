package com.example.animes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaAnimes;
    private Adaptador adaptador;
    ArrayList<Entidad> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = getArrayItems();
        listaAnimes = (ListView) findViewById(R.id.listView);
        adaptador = new Adaptador(this, list);
        listaAnimes.setAdapter(adaptador);

        setListaListener();
    }

    private void setListaListener(){
        listaAnimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, Item.class);
                Bundle ext = new Bundle();

                ext.putString("TITULO", getArrayItems().get(i).getTitulo());

                ext.putString("DESC", getArrayItems().get(i).getDesc());

                intent.putExtras(ext);

                startActivity(intent);

            }
        });
    }

    private ArrayList<Entidad> getArrayItems(){
        ArrayList<Entidad> list = new ArrayList<>();
        list.add(new Entidad(R.drawable.onepiece, "One Piece", 5.0F, "One Piece narra la historia de un joven llamado Monkey D. Luffy, que inspirado por su amigo pirata Shanks, comienza un viaje para alcanzar su sueño, ser el Rey de los piratas, para lo cual deberá encontrar el tesoro One Piece dejado por el anterior rey de los piratas Gol D. Roger."));
        list.add(new Entidad(R.drawable.naruto, "Naruto", 4.0F, "Naruto es una serie de manga escrita e ilustrada por Masashi Kishimoto. La obra narra la historia de un ninja adolescente llamado Naruto Uzumaki, quien aspira a convertirse en Hokage, líder de su aldea, con el propósito de ser reconocido como alguien importante dentro de la aldea y entre sus compañeros."));
        list.add(new Entidad(R.drawable.onepunch, "One Punch Man", 4.0F, "Saitama es un poderoso superhéroe calvo que derrota fácilmente a los monstruos u otros villanos con un único golpe de su puño. Debido a esto, Saitama ha encontrado aburrida su fuerza y siempre está tratando de encontrar rivales más poderosos que le puedan igualar."));
        list.add(new Entidad(R.drawable.fullmetal, "FullMetal Alchemist", 4.5F, "Los hermanos Edward y Alphonse Elric viven en un mundo donde la magia y la alquimia existen y se pueden practicar. Después de la muerte de su madre, juntos tratarán de resucitarla a través de la alquimia."));
        list.add(new Entidad(R.drawable.bluelock, "Blue Lock", 4.0F, "Después de una desastrosa participación en el Mundial de fútbol de 2018, el equipo de Japón busca un delantero \"top\" que pueda inyectar el hambre de victorias y de goles que el equipo necesita, pero para buscarlo necesitarán tomar medidas drásticas... Por lo que deciden juntar a los 300 mejores jugadores jóvenes japoneses en una \"prisión-instituto\" con severos entrenamientos y pruebas hasta poder conseguir al delantero centro perfecto."));
        list.add(new Entidad(R.drawable.sakamoto, "Sakamoto Days", 4.5F, "Tarō Sakamoto era un legendario asesino, temido por todos. Sin embargo, un día encuentra al amor de su vida, por lo que decide retirarse, haciéndose la promesa de que nunca más volverá a matar. Casado y con una hija, Sakamoto vive tranquilo trabajando en su tienda de comestibles."));
        list.add(new Entidad(R.drawable.sololeveling, "Solo Leveling", 4.5F, "En un mundo en el que ciertos humanos poseen habilidades mágicas, llamados cazadores, deben luchar contra monstruos para proteger a la raza humana de una aniquilación segura, un cazador muy débil llamado Sung Jinwoo se encuentra en una lucha en la que solo puede tratar de sobrevivir."));
        list.add(new Entidad(R.drawable.vinland, "Vinland Saga", 3.5F, " La historia está ambientada en la región de Danelaw en el siglo XI y se basa en varias sagas islandesas: el Flateyjarbók, la Saga de los groenlandeses y la Saga de Erik el Rojo. Esta saga relata la historia de Thorfinn en su camino para vengarse de la muerte de su padre en batalla. Sus hazañas para poder retar al asesino de su padre lo llevan a involucrarse en la fuera por la corona de Inglaterra."));

        return list;
    }


}