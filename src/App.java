public class App {

    public static void main(String[] args) {

        // lista de nomes vetor
        Lista<String> nomes = new ListaVetor<>();

        // utilizando add(t valor)
        nomes.add("sarah");
        nomes.add("simone");
        nomes.add("suelen");

        // utilizando size
        System.out.println("tamanho da lista de nomes: " + nomes.size());

        // utilizando get(int pos)
        System.out.println("posição 0: " + nomes.get(0));
        System.out.println("posição 1: " + nomes.get(1));
        System.out.println("posição 2: " + nomes.get(2));

        // utilizando add(t do valor e posicao)
        System.out.println("\napós inserir samara na posição 1:");
        nomes.add("samara", 1);
        System.out.println(nomes);

        // agora, usando remove(t valor)
        nomes.remove("suelen");

        System.out.println("\napós remover suelen:");
        System.out.println(nomes);

        // usando o count
        System.out.println("\nquantidade: " + ListaUtil.count(nomes));

        // nova lista da encadeada
        Lista<Integer> numeros = new ListaEncadeada<>();

        // usando meu add(t valor)
        numeros.add(10);
        numeros.add(25);
        numeros.add(15);
        numeros.add(20);

        System.out.println("\nlista inicial:");
        System.out.println(numeros);

        // utilziando add para adicionar onde eu quero
        numeros.add(30, 1);

        System.out.println("\napós inserir 30 na posição 1:");
        System.out.println(numeros);

        // utilizando get(int pos)
        System.out.println("\nelemento da posição 2: " + numeros.get(2));

        // remove (t valor)
        numeros.remove(Integer.valueOf(15));

        System.out.println("\napós remover 15:");
        System.out.println(numeros);

        // utilizando remove(int pos)
        numeros.remove(1);

        System.out.println("\napós remover o elemento da posição 1:");
        System.out.println(numeros);

        // usando min, max e quantidade da listautil
        System.out.println("\nmaior: " + ListaUtil.max(numeros));
        System.out.println("menor: " + ListaUtil.min(numeros));
        System.out.println("quantidade: " + ListaUtil.count(numeros));

    }
}
