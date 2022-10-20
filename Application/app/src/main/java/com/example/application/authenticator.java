package com.example.application;

import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class authenticator extends AppCompatActivity {

    public boolean checkNameCredentialsInputs(EditText[] editTexts, TextView errorMessages){
        EditText firstName = editTexts[0];
        EditText lastName = editTexts[1];
        EditText email = editTexts[2];
        EditText password = editTexts[3];
        EditText reenterPassword = editTexts[4];

        boolean nameValidation = this.checkFirstLastName(firstName, lastName, errorMessages);
        if (!nameValidation){
            return false;
        }

        boolean credentialValidation = this.checkCredentials(email, password, errorMessages);
        if (!credentialValidation){
            return false;
        }

        String stringPassword = password.getText().toString();
        String stringReenterPassword = reenterPassword.getText().toString();

        if (!stringPassword.equals(stringReenterPassword)){
            errorMessages.setText("Passwords do not match");
            return false;
        }

        return true;


    }

    public boolean checkFirstLastName(@NonNull EditText firstName, @NonNull EditText lastName, TextView errorMessages) {
        String specialCharacters = "(.*[!\"#$%&'()*+,-./:;<=>?@^_`{|}~].*)";

        String stringFirstName = firstName.getText().toString();
        String stringLastName = lastName.getText().toString();

        String[] fullName = {stringFirstName, stringLastName};

        for (String currentName : fullName) {
            if (currentName.equals("")){
                errorMessages.setText("Invalid Name");
                return false;
            }
            if (currentName.matches(specialCharacters)){
                errorMessages.setText("Invalid Name");
                return false;
            }
        }
        return true;
    }

        public boolean checkCredentials (EditText email, EditText password, @NonNull TextView emailPasswordErrorMessages){
            String stringEmail = email.getText().toString();
            String emailValidation = validateEmail(stringEmail);
            String stringPassword = password.getText().toString();
            String passwordValidation = validatePassword(stringEmail, stringPassword);
            if (!emailValidation.equals("Valid Email"))
                emailPasswordErrorMessages.setText(emailValidation);
            else if (!passwordValidation.equals("Valid Password"))
                emailPasswordErrorMessages.setText(passwordValidation);
            else {
                return true;
            }
            return false;
        }

        public String[] getCredentials (@NonNull EditText editTextEmail, @NonNull EditText editTextPassword) {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            return new String[]{email, password};
        }

        public String validateEmail (@NonNull String email){
            if (email.contains("@"))
                return "Valid Email";
            return "Invalid Email";
        }

        public String validatePassword (@NonNull String email, @NonNull String password) {
            String numericCharacters = "(.*[0-9].*)";
            String lowerCaseCharacters = "(.*[a-z].*)";
            String upperCaseCharacters = "(.*[A-Z].*)";
            String specialCharacters = "(.*[@!#$%&].*)";

            if (password.equals(""))
                return "Password cannot be empty";

            else if (password.equals(email))
                return "Email and password cannot be the same";

            else if (password.length() < 8 || password.length() > 20)
                return "Password needs to be between 8 and 20 characters";

            else if (!password.matches(numericCharacters))
                return "Password must contain one number 0-9";

            else if (!password.matches(lowerCaseCharacters))
                return "Password must contain one lower case letter a-z";

            else if (!password.matches(upperCaseCharacters))
                return "Password must contain one upper case letter A-Z";

            else if (!password.matches(specialCharacters))
                return "Password must contain special character @,!,#,$,%,&";

            else
                return "Valid Password";
        }
    public boolean checkAddressCredentialsInputs(EditText[] editTexts, TextView errorMessages){
        EditText line1 = editTexts[0];
        EditText city = editTexts[2];
        EditText province = editTexts[3];
        EditText postalcode = editTexts[4];

        boolean addressValidation = this.checkline1(line1,errorMessages);
        if(!addressValidation){
            return false;
        }
        boolean locationValidation = this.checkCityProvince(city,province, errorMessages);
        if (!locationValidation){
            return false;
        }
        boolean postalcodeValidation = this.checkPostalcode(postalcode,errorMessages);
        if (!postalcodeValidation){
            return false;
        }
        return true;
    }
    public boolean checkline1(@NonNull EditText line1, TextView errorMessages){
        String stringline1= line1.getText().toString();
        String[] address={stringline1};
        for (String currentaddress:address){
            if (currentaddress.equals("")){
                errorMessages.setText("Address is invalid");
                return false;
            }
        }
        return true;
    }
    public boolean checkCityProvince(@NonNull EditText city,@NonNull EditText province, TextView errorMessages){
        String special = "1234567890(.*[!\"#$%&'()*+,-./:;<=>?@^_`{|}~].*)";
        String stringCity =  city.getText().toString();
        String stringProvince= province.getText().toString();

        String[] Location = {stringCity,stringProvince};

        for (String currentLocation : Location) {
            if (currentLocation.equals("")){
                errorMessages.setText("Invalid Province or City");
                return false;
            }
            if (currentLocation.matches(special)){
                errorMessages.setText("Invalid Province or City");
                return false;
            }
        }
        return true;
    }
    public boolean checkPostalcode(@NonNull EditText postalcode,TextView errorMessages){
        String special = "(.*[!\"#$%&'()*+,-./:;<=>?@^_`{|}~].*)";
        String stringPostal = postalcode.getText().toString();
        String[] Postalcode = {stringPostal};
        for (String currentPostal: Postalcode){
            if(currentPostal.equals("")){
                    errorMessages.setText("Invalid Postal Code");
                    return false;
            }
            if (currentPostal.matches(special)){
                errorMessages.setText("Invalid Postal Code");
                return false;
            }
        }
        return true;
    }
    public boolean checkCCInputs(EditText[] editTexts, TextView errorMessages){
        EditText noc = editTexts[0];
        EditText ccnumber = editTexts[1];
        EditText cvvnumber = editTexts[2];
        EditText expdate = editTexts[3];

        boolean nocValidation = this.checknoc(noc,errorMessages);
        if (!nocValidation){
            return false;
        }
        boolean CcCvvValidation = this.checkccnumber(ccnumber,cvvnumber,errorMessages);
        if(!CcCvvValidation) {
            return false;
        }
        boolean expdateValidation = this.checkexpdate(expdate, errorMessages);
        if(!expdateValidation){
            return false;
        }
        return true;
    }
    public boolean checknoc(@NonNull EditText noc,TextView errorMessages){
        String special = "1234567890(.*[!\"#$%&'()*+,-./:;<=>?@^_`{|}~].*)";
        String stringnoc = noc.getText().toString();
        String[] NOC={stringnoc};
        for (String currentNOC:NOC){
            if (currentNOC.equals("")){
                errorMessages.setText("Invalid Name On Card");
                return false;
            }
            if  (currentNOC.matches(special)){
                errorMessages.setText("Invalid Name On Card");
                return false;
            }
        }
        return true;
    }
    public boolean checkccnumber(@NonNull EditText ccnumber,@NonNull EditText cvvnumber, TextView errorMessages){
        String lowerCaseCharacters = "(.*[a-z].*)";
        String upperCaseCharacters = "(.*[A-Z].*)";
        String special = "(.*[@!#$%&].*)";
        String stringccnumber = ccnumber.getText().toString();
        String stringcvvnumber = cvvnumber.getText().toString();
        String[] cnums={stringccnumber,stringcvvnumber};
        for (String currentcnums:cnums){
            if (currentcnums.equals("")){
                errorMessages.setText("Invalid Credit Card/CVV");
                return false;
            }
            if (currentcnums.matches(lowerCaseCharacters)){
                errorMessages.setText("Credit Card/CVV must be numerical digits");
                return false;
            }
            if (currentcnums.matches(upperCaseCharacters)){
                errorMessages.setText("Credit Card/CVV must be numerical digits");
                return false;
            }
            if (currentcnums.matches(special)){
                errorMessages.setText(("Credit Card/CVV must not contain special characters"));
                return false;
            }
        }
        return true;
    }
    public boolean checkexpdate(@NonNull EditText expdate, TextView errorMessages){
        String lowerCaseCharacters = "(.*[a-z].*)";
        String upperCaseCharacters = "(.*[A-Z].*)";
        String special = "(.*[!\"#$%&'()*+,-.:;<=>?@^_`{|}~].*)";
        String stringexpdate= expdate.getText().toString();
        String[] expnums={stringexpdate};
        for (String currentexpnums:expnums){
            if(currentexpnums.equals("")){
                errorMessages.setText("Expiration date is left empty");
                return false;
            }
            if (currentexpnums.matches(lowerCaseCharacters)){
                errorMessages.setText("Expiration date must only contain numbers");
                return false;
            }
            if (currentexpnums.matches(upperCaseCharacters)){
                errorMessages.setText("Expiration date must only contain numbers");
                return false;
            }
            if (currentexpnums.matches(special)){
                errorMessages.setText("Expiration date must not contain special characters");
                return false;
            }
            if (currentexpnums.length()>7 || currentexpnums.length()<7){
                errorMessages.setText("Expiration date must follow MM/YYYY format");
                return false;
            }
            if (currentexpnums.indexOf("/")!=2){
                errorMessages.setText("Expiration date must follow MM/YYYY format");
                return false;
            }
        }
        return true;
    }
}
