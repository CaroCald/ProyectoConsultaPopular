/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultapopular;

/**
 *
 * @author Carolina
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controlardatos {

    public boolean detectarNo(String linea) {

        if ((linea) != null) {
            if (linea.contains("#EcuadorDiceNO") || linea.contains("#DilesNO")
                    || linea.contains("#TodoNO") || linea.contains("Todo N")
                    || linea.contains("#Todono") || linea.contains("Nooo") || linea.contains("7 veces n")
                    || linea.contains("#YoVotoNO") || linea.contains("#7VecesNO")
                    || linea.contains("#PorLaPatriaDilesNO")
                    || linea.contains("#YoVotNO") || linea.contains("vota no") || linea.contains("MoreNO")
                    || linea.contains("#NoALaConsultaMa") || linea.contains("#ElPuebloContigoRafael")
                    || linea.contains("¡NO")
                    || linea.contains("#DilesN") || linea.contains("#EcuadorDiceN")
                    || linea.contains("#ConsultaMentirosa")) {
                return true;
            }
        }

        return false;
    }

    public void buscar() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/consultapopular/trainLimpio.txt"));
            String linea = "";
            Boolean estado = false;
            while ((linea = br.readLine()) != null) {

                //Cadenas que contienen hashtag en favor del No
                if (linea.contains("#EcuadorDiceNO") || linea.contains("#DilesNO") 
                        || linea.contains("#TodoNO") || linea.contains("Todo N")
                        || linea.contains("#Todono") || linea.contains("Nooo") || linea.contains("7 veces n")
                        || linea.contains("#YoVotoNO") || linea.contains("#7VecesNO") 
                        || linea.contains("#PorLaPatriaDilesNO")
                        || linea.contains("#YoVotNO") || linea.contains("vota no") || linea.contains("MoreNO")
                        || linea.contains("#PichinchaDiceN") || linea.contains("#PichinchaConElNo")
                        || linea.contains("#DilesN") || linea.contains("#SieteVecesN")
                        || linea.contains("#ConsultaMentirosa") || linea.contains("#AzuayDiceN")
                        || linea.contains("#NoALaConsultaMa") || linea.contains("#ElPuebloContigoRafael") 
                        || linea.contains("#GuayasDiceN")) {

                    linea = linea + " , NO";
                    estado = true;
                } else {
                    //Hashtags referente a la consulta de pero no estan a favor del si ni del no
                    if (linea.contains("#ConsultaPopular2018") 
                            || linea.contains("#ReferendumConsultaPopular2018febrero04")
                            || linea.contains("@Lenin") || linea.contains("#VotacionesEcuador") 
                            || linea.contains("##consulta2018")
                            || linea.contains("#votaciones") || linea.contains("@MashiRafael") 
                            || linea.contains("#votonacional")
                            || linea.contains("#GuayasDiceN") || linea.contains("#PichinchaDiceN") 
                            || linea.contains("#PichinchaConElNo")
                            || linea.contains("#votaconconciencia") || linea.contains("#votaconresponsabilidad") 
                            || linea.contains("#EcuadorSaleAVotar")) {

                        if (detectarNo(linea) == true) {
                            linea = linea + " , NO";
                            estado = true;
                        } else {
                            if (detectarSi(linea) == true) {
                                linea = linea + " , SI";
                                estado = true;
                            }
                        }
                    } else {
                        if ((linea.contains("#7VecesS") || linea.contains("#7VecesSi") || linea.contains("#VotaTodoS")
                                || linea.contains("#Votar") || linea.contains("#votoreflexivo") 
                                || linea.contains("#VotaS")
                                || linea.contains("#TerceraVaECUADOR") || linea.contains("#EcuadorDiceSi")
                                || linea.contains("#Vota7vecesS.") || linea.contains("#TerceraVa") 
                                || linea.contains("#votaciones2018SI")
                                || linea.contains("#votaciones2018S") || linea.contains("#votaciones2018s")
                                || linea.contains("##consulta2018") || linea.contains("#VotaTodoSi") 
                                || linea.contains("#VotoEnCasa")
                                || linea.contains("#VotaNulo") || linea.contains("#ATuFuturoDileSi")
                                || linea.contains("#EcuadorDiceS") || linea.contains("#GuayasDiceS")
                                || linea.contains("#TodoSi") || linea.contains("#TodoSI") 
                                || linea.contains("#TodoS") || linea.contains("#Si")
                                || linea.contains("#NOALaViolencia") || linea.contains("#JuntosPorElS") 
                                || linea.contains("#ObvioQueS")
                                || linea.contains("7 veces s") || linea.contains("#NoBotesTuVoto") 
                                || linea.contains("vota si")
                                || linea.contains("#PichinchaDiceS")) || linea.contains("#AzuayDiceS")
                                && (!linea.contains("#SiSePuede")) && (!linea.contains("#Sismo"))
                                && (!linea.contains("#Sin"))) {

                            linea = linea + " , SI ";
                            estado = true;

                        } else {
                            estado = false;
                        }
                    }
                }
                if (estado) {
                    System.out.println(linea);
                } 
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TweetsBI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TweetsBI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean detectarSi(String linea) {
        if ((linea) != null) {
            if ((linea.contains("#7VecesS") || linea.contains("#7VecesSi") || linea.contains("#VotaTodoS")
                    || linea.contains("#Votar") || linea.contains("#votoreflexivo") || linea.contains("#VotaS")
                    || linea.contains("#TerceraVaECUADOR") || linea.contains("#EcuadorDiceSi")
                    || linea.contains("#Vota7vecesS.") || linea.contains("#TerceraVa")
                    || linea.contains("#votaciones2018SI")
                    || linea.contains("##consulta2018") || linea.contains("#VotaTodoSi")
                    || linea.contains("#VotoEnCasa")
                    || linea.contains("#VotaNulo") || linea.contains("#ATuFuturoDileSi")
                    || linea.contains("#TodoSi") || linea.contains("#TodoSI")
                    || linea.contains("#TodoS") || linea.contains("#Si")
                    || linea.contains("#NOALaViolencia") || linea.contains("#JuntosPorElS")
                    || linea.contains("#ObvioQueS")
                    || linea.contains("7 veces s") || linea.contains("#NoBotesTuVoto")
                    || linea.contains("vota si") || linea.contains("¡Si")
                    || linea.contains("#votaciones2018S") || linea.contains("#votaciones2018s")
                    || linea.contains("#EcuadorDiceS") || linea.contains("#GuayasDiceS")
                    || linea.contains("#PichinchaDiceS"))
                    && (!linea.contains("#Sismo") || !linea.contains("#SiSe"))) {
                return true;
            }
        }

        return false;
    }
}
