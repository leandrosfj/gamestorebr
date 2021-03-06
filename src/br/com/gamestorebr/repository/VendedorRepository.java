package br.com.gamestorebr.repository;

import br.com.gamestorebr.model.pessoa.Vendedor;
import br.com.gamestorebr.model.produtos.Produto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendedorRepository {

  private final Map<String, Vendedor> registros = new HashMap<>();

  public void add(final Vendedor vendedor) {

    if (registros.get(vendedor.getDocumento()) != null) {

      System.out.println("\nERRO: Vendedor já cadastrado para CNPJ informado...");

      return;
    }

    registros.putIfAbsent(vendedor.getDocumento(), vendedor);

    System.out.println("\nVendedor cadastrado com sucesso!");
  }

  public Vendedor get(final String documento) {
    return registros.get(documento);
  }

  public void update(final Vendedor vendedor) {
    registros.put(vendedor.getDocumento(), vendedor);
  }

  public Vendedor getByName(final String nome) {
    return registros.values().stream()
        .filter(vendedor -> vendedor.getNome().equals(nome))
        .findFirst()
        .orElse(null);
  }

  public void delete(final String documento) {
    registros.remove(documento);
  }

  public List<Vendedor> listAll() {
    return new ArrayList<>(registros.values());
  }

  public void addProduto(final String documento, final Produto produto) {

    final Vendedor vendedor = get(documento);

    if (vendedor == null) {

      System.out.println("\nVendedor não encontrado!");
      return;
    }

    final Map<Integer, Produto> catalogo = vendedor.getCatalogo();

    final boolean produtoExisteNoCatalogo =
        catalogo.values().stream().anyMatch(item -> item.equals(produto));

    if (produtoExisteNoCatalogo) {
      System.out.println("\nERRO: Produto já existe no catálogo: " + produto.getNome());
      return;
    }

    final int codigo =
        (catalogo.values().stream().map(Produto::getCodigo).collect(Collectors.toList()).stream()
                .max(Comparator.comparing(Integer::valueOf))
                .orElse(0))
            + 1;

    produto.setCodigo(codigo);
    catalogo.putIfAbsent(produto.getCodigo(), produto);

    System.out.println("\nProduto cadastrado com sucesso!");
  }
}
