package pocGraphql.entities.client.inputs;

import pocGraphql.entities.client.model.Client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClientInput {

    @NotBlank
    public String name;

    @NotBlank
    @Email
    public String email;

    public ClientInput(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ClientInput() {
    }

    public Client toModel() {
        return new Client(this.name, this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
