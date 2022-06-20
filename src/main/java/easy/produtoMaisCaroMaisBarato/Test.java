package easy.produtoMaisCaroMaisBarato;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Lamborghini", 1000000));
        produtos.add(new Produto("Jipe", 46000));
        produtos.add(new Produto("Brasilia", 16000));
        produtos.add(new Produto("Smart", 46000));
        produtos.add(new Produto("Fusca", 17000));

        Optional<Produto> max = produtos.stream().max(Comparator.comparingDouble(p -> p.preco));
        Optional<Produto> min = produtos.stream().min(Comparator.comparingDouble(p -> p.preco));
        System.out.println(max.get().nome);
        System.out.println(min.get().nome);
    }
}

class Produto{
    String nome;
    double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }


}
