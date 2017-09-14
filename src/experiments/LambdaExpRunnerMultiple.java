package experiments;

import edu.cornell.cs.nlp.utils.log.ILogger;
import edu.cornell.cs.nlp.utils.log.LoggerFactory;
import experiments.explat.LambdaExperiment;
import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by edwardwilliams on 6/22/17.
 */
public class LambdaExpRunnerMultiple {

    private static void doExperiment(String[] args){
        ILogger LOG	= LoggerFactory.create(LambdaExpRunner.class);
        if (args.length < 1) {
            LOG.error("Missing arguments. Expects a .exp file as argument.");
            System.exit(-1);
        }
        try {
            System.out.println("here!!!");
            long start = System.currentTimeMillis();
            LambdaExperiment a = new LambdaExperiment(new File(args[0]));
            a.start();
            System.out.println("\t" + (System.currentTimeMillis() - start));
            a.end();
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printTest(int i){
        try(FileInputStream inputStream = new FileInputStream("experiments/weakly/our_method_50_1/test.out")) {
            String allText = IOUtils.toString(inputStream);
            // do something with everything string
            System.out.println(i+ " : " + allText);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static final ILogger LOG	= LoggerFactory.create(LambdaExpRunner.class);

    public static void main(String[] args) {

        for(int i=0;i<100;i++) {
            doExperiment(args);
            printTest(i);
        }
    }
}
