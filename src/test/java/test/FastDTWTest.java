package test;

import com.dtw.TimeWarpInfo;
import com.timeseries.TimeSeries;
import com.util.DistanceFunction;
import com.util.DistanceFunctionFactory;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * FastDTWTest Tester.
 *
 * @author <Roberto Maestre>
 * @version 1.0
 * @since <pre>12/04/2014</pre>
 */

public class FastDTWTest extends TestCase {
    public FastDTWTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(FastDTWTest.class);
    }



    public void testTimeSeriesFromFile() throws Exception {

        // Create two series from file resources
        TimeSeries tsI = new TimeSeries(FastDTWTest.class.getResource("/trace0.csv").getPath(), false, false, ',');
        TimeSeries tsJ = new TimeSeries(FastDTWTest.class.getResource("/trace0.csv").getPath(), false, false, ',');

        // Create Euclidean Distance
        final DistanceFunction distFn = DistanceFunctionFactory.getDistFnByName("EuclideanDistance");

        // Perform Fast DTW
        final TimeWarpInfo info = com.dtw.FastDTW.getWarpInfoBetween(tsI, tsJ, 3, distFn);

        // Assert
        assertEquals(info.getDistance(), 0.0);
    }



    public void testTimeSeriesAdHocCreationOneDimension() throws Exception {

        // Create two series from file resources
        TimeSeries tsIFile = new TimeSeries(FastDTWTest.class.getResource("/trace0.csv").getPath(), false, false, ',');
        TimeSeries tsIInline = new TimeSeries(new double[]{0.57311057,0.66785286,0.6204376,0.64280256,0.69667441,0.60423623,0.64343652,0.61178161,0.59182763,0.65136824,0.70621285,0.62661441,0.63508771,0.63493228,0.65136735,0.61981525,0.61945448,0.64590288,0.62938595,0.6150395,0.60069304,0.65337883,0.60441837,0.66969806,0.58656615,0.59828824,0.62125784,0.60977774,0.6949783,0.66577539,0.66410621,0.66894924,0.66361617,0.63622588,0.65850312,0.59451448,0.6234844,0.62165098,0.61981756,0.7019492,0.66234668,0.61873318,0.69467881,0.64707411,0.64536244,0.67142135,0.67745033,0.68496453,0.63682165,0.7384499,0.67069979,0.654223,0.62456789,0.67168032,0.67119328,0.75337773,0.747092,1.0590174,2.3250588,3.4873881,3.791198,3.7899448,3.2356643,0.96637488,-1.1677632,-1.7274525,-1.8816157,-1.8021733,-1.8164734,-1.7923957,-1.850596,-1.9086144,-1.7596231,-1.8207655,-1.7730543,-1.7715936,-1.8003921,-1.7846008,-1.8280372,-1.7105793,-1.7328188,-1.756744,-1.7349602,-1.750085,-1.7439173,-1.7779521,-1.6195627,-1.6262147,-1.6809786,-1.6223607,-1.6163647,-1.6456588,-1.6256553,-1.6056518,-1.6343714,-1.663091,-1.5727687,-1.6348872,-1.6676164,-1.5563619,-1.4733684,-1.5179187,-1.5260838,-1.5149402,-1.4491856,-1.4446944,-1.4456101,-1.5180127,-1.4309208,-1.4130516,-1.3747699,-1.3074566,-1.2869564,-1.2739287,-1.2729787,-1.2720288,-1.256319,-1.1997423,-1.2157275,-1.2351879,-1.1222517,-1.1209553,-1.0717478,-1.0180988,-1.0351622,-1.0328671,-0.93370971,-0.89335876,-0.89643021,-0.86252033,-0.82410419,-0.82367439,-0.692337,-0.746304,-0.7713252,-0.69456771,-0.64370047,-0.62974647,-0.56133304,-0.56709927,-0.52964651,-0.42854236,-0.44129178,-0.39679358,-0.40249162,-0.40192458,-0.4013575,-0.35082649,-0.30779764,-0.29437947,-0.30484832,-0.24148527,-0.18381335,-0.19987659,-0.2159398,-0.1985224,-0.18110496,-0.13173638,-0.087459749,-0.062955863,-0.041215888,0.0095323352,0.0072543967,0.084682036,0.0202619,-0.030277433,0.1670332,0.15914285,0.13626244,0.1836408,0.11241308,0.24576393,0.18632854,0.21406466,0.22620432,0.31480799,0.35178686,0.32169672,0.29160658,0.30336855,0.35534858,0.29798175,0.3929259,0.33834023,0.34169593,0.35460278,0.42734969,0.38570072,0.39539855,0.40073368,0.40019646,0.48591525,0.47656649,0.48756627,0.44086517,0.43978765,0.46205459,0.5212762,0.51004323,0.5036782,0.5109009,0.48741534,0.54346976,0.50172901,0.50772729,0.58882315,0.52353432,0.50751189,0.57714285,0.58437349,0.59160413,0.53913905,0.56032017,0.49284227,0.5576623,0.57859378,0.57397142,0.56934907,0.54420273,0.5190564,0.59563183,0.54512078,0.60829295,0.52673663,0.61082449,0.56932651,0.57477214,0.60760529,0.61184582,0.59435067,0.4725241,0.59064683,0.6095451,0.64691218,0.58993848,0.60722695,0.65481208,0.56966599,0.61134846,0.61637838,0.5711741,0.61360047,0.65545141,0.6341302,0.5745744,0.58673918,0.60868116,0.64270585,0.62874822,0.60072754,0.62519076,0.60468692,0.59472649,0.58036291,0.53519515,0.67051107,0.650373,0.61595612,0.62880588,0.62330423,0.63832124,0.60648174,0.58378467,0.5610876,0.66404759,0.60590369,0.66134451,0.60240123,0.68621532,0.62031986,0.61865867,0.66502758,0.70639446,0.60791656,0.59813814});

        TimeSeries tsJFile = new TimeSeries(FastDTWTest.class.getResource("/trace1.csv").getPath(), false, false, ',');
        TimeSeries tsJInline = new TimeSeries(new double[]{0.61543759,0.58163419,0.62914481,0.62535561,0.62036891,0.61944155,0.63006706,0.58448635,0.6486644,0.67803634,0.58094387,0.56500901,0.63096351,0.63785716,0.61497943,0.61381799,0.57847491,0.56927614,0.64821908,0.60299194,0.62189862,0.60704502,0.59719403,0.60477473,0.59282237,0.57368399,0.61429634,0.64989676,0.53150638,0.66547968,0.56914716,0.57760337,0.64611326,0.6474521,0.59731598,0.63388794,0.5862729,0.62090035,0.572956,0.62985826,0.62116745,0.56589174,0.63041295,0.58669127,0.5679607,0.67928514,0.61468149,0.5305806,0.56405582,0.57339534,0.6132087,0.56209365,0.55693217,0.6493345,0.59772193,0.56992829,0.64344849,0.63498418,0.60989255,0.63121078,0.637095,0.61290433,0.6280845,0.58255532,0.59357096,0.64260878,0.61860301,0.61424359,0.65530274,0.66071887,0.58362866,0.59509982,0.54385616,0.59191139,0.59890578,0.60983335,0.62163562,0.64050327,0.64614693,0.62282188,0.60047365,0.62106068,0.67105359,0.60023479,0.62706328,0.65406299,0.67849634,0.68887714,0.64974128,0.64654925,0.6463664,0.63599193,0.65619838,0.64638936,0.60596047,0.69585182,0.65136678,0.64818018,0.65404183,0.73102617,1.0819119,2.3612106,3.9054754,3.8925614,3.2595949,1.022107,-1.3211587,-1.9108229,-1.918211,-1.9437076,-1.9194874,-1.9184595,-1.914012,-1.9573294,-1.8762711,-1.9326649,-1.9564989,-1.9076406,-1.8793844,-1.8724147,-1.8635678,-1.8797478,-1.8741759,-1.9036498,-1.891053,-1.832171,-1.8520658,-1.8549623,-1.8059758,-1.7988175,-1.8009743,-1.7635652,-1.6990452,-1.7274687,-1.6724238,-1.7215854,-1.6825233,-1.6969033,-1.6551394,-1.6620739,-1.6604387,-1.6529645,-1.5878488,-1.612829,-1.6002128,-1.5793027,-1.5685092,-1.4552281,-1.4642708,-1.4643484,-1.432397,-1.3956933,-1.3906324,-1.3539318,-1.3328948,-1.2573517,-1.2100065,-1.2554781,-1.2139017,-1.1097356,-1.1172046,-1.1360144,-1.105545,-1.0170688,-1.0185803,-0.99522698,-0.97423537,-0.96821025,-0.91951551,-0.86285969,-0.80394331,-0.73881714,-0.707979,-0.7183229,-0.71749501,-0.63632485,-0.52423378,-0.6843006,-0.44405213,-0.5103406,-0.46071159,-0.43913096,-0.42349135,-0.33785106,-0.32679863,-0.31326155,-0.2984019,-0.27213106,-0.19943141,-0.16132776,-0.18171045,-0.19358837,-0.077149309,-0.079967717,-0.014788358,-0.025289824,-0.0026343812,7.9220424E-4,0.029752023,0.061316435,0.10839886,0.099127406,0.1494675,0.10431208,0.12600925,0.1345035,0.20774869,0.22564603,0.21301959,0.17974428,0.2773906,0.22534152,0.30727789,0.31336179,0.37891982,0.35987703,0.31310571,0.31553268,0.37453434,0.36682382,0.43014489,0.41359523,0.3709805,0.4530754,0.3962412,0.36843694,0.44745504,0.45924406,0.45141181,0.44535615,0.47988174,0.45598829,0.50556183,0.49223485,0.52707542,0.45971514,0.48267354,0.52329721,0.50706265,0.52985252,0.51493119,0.522444,0.50760837,0.52063858,0.52594378,0.55482081,0.52736523,0.43682448,0.51559674,0.55552247,0.61225487,0.59321284,0.61559959,0.59819349,0.5675172,0.55590459,0.52061079,0.55933923,0.54973968,0.51618795,0.56468642,0.57133032,0.57171659,0.59211886,0.59171499,0.60431336,0.59567242,0.53698209,0.6275631,0.56843297,0.58627467,0.55818566,0.61327235,0.536016,0.56201019});

        // Create Euclidean Distance
        final DistanceFunction distFn = DistanceFunctionFactory.getDistFnByName("EuclideanDistance");

        // Perform Fast DTW
        final TimeWarpInfo infoTSFiles = com.dtw.FastDTW.getWarpInfoBetween(tsIFile, tsJFile, 3, distFn);
        final TimeWarpInfo infoTSInline = com.dtw.FastDTW.getWarpInfoBetween(tsIInline, tsJInline, 3, distFn);

        assertEquals(infoTSFiles.getDistance(),infoTSInline.getDistance());
        assertEquals(infoTSFiles.getPath(),infoTSInline.getPath());

    }


}
