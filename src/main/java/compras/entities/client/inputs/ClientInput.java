package compras.entities.client.inputs;

import compras.entities.client.model.Client;

public class ClientInput {

    public String name;
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
