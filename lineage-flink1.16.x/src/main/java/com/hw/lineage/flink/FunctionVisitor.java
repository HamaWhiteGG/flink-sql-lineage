package com.hw.lineage.flink;

import org.apache.calcite.sql.SqlBasicCall;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.util.SqlBasicVisitor;
import org.apache.flink.table.catalog.UnresolvedIdentifier;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: FunctionVisitor
 * @author: HamaWhite
 */
public class FunctionVisitor extends SqlBasicVisitor<Void> {

    private final List<UnresolvedIdentifier> functionList = new ArrayList<>();

    @Override
    public Void visit(SqlCall call) {
        if (call instanceof SqlBasicCall && call.getOperator() instanceof SqlFunction) {
            SqlFunction function = (SqlFunction) call.getOperator();
            SqlIdentifier opName = function.getNameAsId();

            functionList.add(UnresolvedIdentifier.of(opName.names));
        }
        return super.visit(call);
    }

    public List<UnresolvedIdentifier> getFunctionList() {
        return functionList;
    }
}
