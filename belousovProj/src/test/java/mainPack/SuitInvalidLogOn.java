package mainPack;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                DealCreate.class,
                DealDelete.class,
                SparCreate.class,
                SparDelete.class,
                ProviderCreate.class,
                ProviderDelete.class
        }
)


public class SuitInvalidLogOn {

}
