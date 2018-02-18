/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultapopular;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carolina
 */
public class limpiezaTexto {

    /**
     * @param args the command line arguments
     */
    public void escribir(String a) throws IOException {
        String ruta = "src/consultapopular/testLimpio.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(a);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(a);
        }
        bw.close();
    }

    private static void clasificar(String s) {

    }

    public void quitarURL() {

        try {
            //leer archivo
            BufferedReader br = new BufferedReader(new FileReader("src/consultapopular/train.txt"));
            String s2;
            String linea;
            //leer el archivo linea por linea
            while ((linea = br.readLine()) != null) {
                String texto[] = linea.split(" ");
                //separar el texto por palabras
                for (String palabra : texto) {
                    if (palabra.contains("https://t.co")) {
                        //reemplazar los urls por un espacio 
                        //para de esa manera poder eliminarlos del texto
                        s2 = palabra.replace(palabra, " ");
                    } else {
                        //imprimir el texto limpio
                        System.out.print(" " + palabra);
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + e);
        }

    }

    public boolean patron(String text, String patternString) {

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public void buscar() {
        try {

            BufferedReader br = new BufferedReader(new FileReader("src/consultapopular/trainLimpio.txt"));
            String linea = "";
            int puntaje = 0, p = 0;
            Boolean estado = false;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("#EcuadorDiceNO") || linea.contains("#ElPuebloContigoRafael")
                        || linea.contains("#ElPuebloContigoRafael") || linea.contains("#ConsultaPopular2018")
                        || linea.contains("#7VecesS") || linea.contains("#7VecesSi")
                        || linea.contains("#VotaTodoS") || linea.contains("#Votar")
                        || linea.contains("#ReferendumConsultaPopular2018febrero04") || linea.contains("#TerceraVaECUADOR")
                        || linea.contains("#Vota7vecesS.") || linea.contains("#TerceraVa")
                        || linea.contains("#TerceraVaECUADOR") || linea.contains("#votaciones2018SI")
                        || linea.contains("#votaciones ") || linea.contains("@Lenin")
                        || linea.contains("#EcuadorDiceSi ") || linea.contains("#VotacionesEcuador ")
                        || linea.contains("##consulta2018") || linea.contains("#DilesNO")
                        || linea.contains("#VotaTodoSi") || linea.contains("#VotoEnCasa")
                        || linea.contains("#votoreflexivo") || linea.contains("#EcuadorSaleAVotar ")
                        || linea.contains("#VotaNulo") || linea.contains("#ATuFuturoDileSi")
                        || linea.contains("#votonacional") || linea.contains("#votaconconciencia")
                        || linea.contains("#votaconresponsabilidad") || linea.contains("#VotaS")
                        || linea.contains("@MashiRafael") || linea.contains("#TodoNO")
                        || linea.contains("#TodoSi") || linea.contains("#TodoSI")
                        || linea.contains("#Todono") || linea.contains("#TodoS")
                        || linea.contains("#Si") || linea.contains("#NoALaConsultaMaosa")
                        || linea.contains("#NOALaViolencia") || linea.contains("MoreNO")
                        || linea.contains("#JuntosPorElS") || linea.contains("#ObvioQueS")
                        || linea.contains("#YoVotoNO") || linea.contains("Nooo")
                        || linea.contains("7 veces s") || linea.contains("7 veces n")
                        || linea.contains("#YoVotoNO") || linea.contains("#7VecesNO")
                        || linea.contains("#PorLaPatriaDilesNO") || linea.contains("##NoBotesTuVoto")
                        || linea.contains("#YoVotNO") || linea.contains("vota si")
                        || linea.contains("vota no")) {
                    estado = true;
                } else {
                    estado = false;

                }
                if (estado) {
                    System.out.println(linea + " ");
                } else {
                }

            }

        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + e);
        }
    }

   

}
