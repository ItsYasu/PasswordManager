module com.yasu.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.yasu.passwordmanager to javafx.fxml;
    exports com.yasu.passwordmanager;
}