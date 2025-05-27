package dialect;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyFunctionContributor implements FunctionContributor {
    @Override
    public void contributeFunctions(FunctionContributions fc) {
        fc.getFunctionRegistry().register(
          "group_concat",
          new StandardSQLFunction("group_concat", StandardBasicTypes.STRING)
        );
    }
}
