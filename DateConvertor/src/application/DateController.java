package application;

import application.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class DateController {

	@FXML
	private TextField month, day, hour, minute, second, finalValue;
	@FXML
	private ChoiceBox<String> unit;

	// textField
	@FXML
	public void write(KeyEvent event) {

		final TextField currentTextField = (TextField) event.getSource();
		final char addedCharacter = event.getCharacter().charAt(0);
		// Get text of text field plus the added character
		String currentSentence = addedCharacter == '\b' ? currentTextField
				.getText() : currentTextField.getText() + addedCharacter;

		// Check if user write alphabetic character, otherwise, the event is
		// canceled
		for (final char c : currentSentence.toCharArray()) {
			if (!Utils.isNumber(c) && c != '\b' && c != '\u0016') {
				System.out.println("event is canceled by: " + c);
				event.consume();
				return;
			}
		}

		DateUnit requiedUnit = DateUnit.getDateUnitByName(unit.getValue());

		TextField[] textFields = {second, minute, hour, day, month};

		long time = 0L;

		for (int i = DateUnit.values().length - 1; i > requiedUnit.ordinal() - 1; i--) {
			time += DateUnit.convertTime(
					DateUnit.values()[i],
					currentTextField != textFields[i] ? 
							(textFields[i].getText().isEmpty() ? 0 : Long.parseLong(textFields[i].getText())) :
							(currentSentence.isEmpty() ? 0 : Long.parseLong(currentSentence)),
					requiedUnit);
		}

		for (int i = 0; i < requiedUnit.ordinal(); i++) {}

		this.finalValue.setText(Long.toString(time));

	}

	// Scroller
	@FXML
	public void convertUnit(ActionEvent event) {
		DateUnit requiedUnit = DateUnit.getDateUnitByName(unit.getValue());

		TextField[] textFields = {second, minute, hour, day, month};

		long time = 0L;

		for (int i = DateUnit.values().length - 1; i > requiedUnit.ordinal() - 1; i--) {
			time += DateUnit.convertTime(
					DateUnit.values()[i],
					textFields[i].getText().isEmpty() ? 0 : Integer
							.parseInt(textFields[i].getText()),
					requiedUnit);
		}

		for (int i = 0; i < requiedUnit.ordinal(); i++) {}

		this.finalValue.setText(Long.toString(time));
	}

}
