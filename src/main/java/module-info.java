module com.github.coryrobertson.peekinpietextdecoding {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.commons.io;


    opens com.github.coryrobertson.peekinpietextdecoding to javafx.fxml;
    exports com.github.coryrobertson.peekinpietextdecoding;
}