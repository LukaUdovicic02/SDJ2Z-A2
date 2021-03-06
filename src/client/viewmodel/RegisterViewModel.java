package client.viewmodel;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;

public class RegisterViewModel
{
  private Model model;
  private StringProperty username, password, error;
  private UserInformation userInformation;

  public RegisterViewModel(Model model, UserInformation userInformation){
    this.model = model;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
    this.userInformation = userInformation;
  }

  public void clear(){
    username.setValue(null);
    password.setValue(null);
    error.setValue(null);
  }


  public boolean register() throws Exception
  {
    boolean result = false;
    if (username != null && password != null)
    {
      try {
        result = model.registerUser(username.get(), password.get());
        userInformation.setUser(username.get());
      } catch (Exception e){
        error.setValue(e.getMessage());
      }

    }
    else {
      error.setValue("there is missing name or password");
    }
    return result;
  }

  public StringProperty getUsername()
  {
    return username;
  }

  public StringProperty getPassword()
  {
    return password;
  }

  public StringProperty getError(){
    return error;
  }
}
