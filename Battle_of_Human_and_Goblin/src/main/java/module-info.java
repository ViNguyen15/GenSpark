module com.example.battle_of_human_and_goblin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.battle_of_human_and_goblin to javafx.fxml;
    exports com.example.battle_of_human_and_goblin;
}