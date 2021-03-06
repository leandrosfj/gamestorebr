package br.com.gamestorebr.form.vendedor;

import br.com.gamestorebr.form.components.VisualizarVendedorButton;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableViewVendedorItem {

  private final SimpleStringProperty nome;
  private final SimpleStringProperty cnpj;
  private final SimpleStringProperty saldo;
  private final SimpleObjectProperty<VisualizarVendedorButton> visualizarButton;

  public TableViewVendedorItem(final String nome, final String cnpj, final String saldo) {
    this.nome = new SimpleStringProperty(nome);
    this.cnpj = new SimpleStringProperty(cnpj);
    this.saldo = new SimpleStringProperty(saldo);
    visualizarButton = new SimpleObjectProperty(new VisualizarVendedorButton(cnpj));
  }

  public String getNome() {
    return nome.get();
  }

  public SimpleStringProperty nomeProperty() {
    return nome;
  }

  public void setNome(final String nome) {
    this.nome.set(nome);
  }

  public String getCnpj() {
    return cnpj.get();
  }

  public SimpleStringProperty cnpjProperty() {
    return cnpj;
  }

  public void setCnpj(final String cnpj) {
    this.cnpj.set(cnpj);
  }

  public String getSaldo() {
    return saldo.get();
  }

  public SimpleStringProperty saldoProperty() {
    return saldo;
  }

  public void setSaldo(final String saldo) {
    this.saldo.set(saldo);
  }

  public VisualizarVendedorButton getVisualizarButton() {
    return visualizarButton.get();
  }

  public SimpleObjectProperty<VisualizarVendedorButton> visualizarButtonProperty() {
    return visualizarButton;
  }

  public void setVisualizarButton(final VisualizarVendedorButton visualizarButton) {
    this.visualizarButton.set(visualizarButton);
  }
}
