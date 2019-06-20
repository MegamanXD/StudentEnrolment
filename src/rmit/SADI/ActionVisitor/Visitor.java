package rmit.SADI.ActionVisitor;

import rmit.SADI.Actions.*;

public interface Visitor {
    public void visit(AddEnrolment addEnrolment);
    public void visit(DeleteEnrolment deleteEnrolment);
}