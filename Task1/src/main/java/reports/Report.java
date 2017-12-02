package reports;

import java.util.List;

public interface Report {

     List getWorkList();
     void showWork(final String name,final int indentLevel);

}
