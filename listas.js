class ListNode {
    constructor(val, next = null) {
        this.val = val;
        this.next = next;
    }
}

function mesclarListas(l1, l2) {
    let aux = new ListNode(0);
    let atual = aux;

    while (l1 && l2) {
        if (l1.val < l2.val) {
            atual.next = l1;
            l1 = l1.next;
        } else {
            atual.next = l2;
            l2 = l2.next;
        }
        atual = atual.next;
    }
    atual.next = l1 || l2;
    return aux.next;
}

// Função auxiliar para criar lista a partir de array
function arrParaLista(arr) {
    let aux = new ListNode(0);
    let current = aux;
    for (let val of arr) {
        current.next = new ListNode(val);
        current = current.next;
    }
    return aux.next;
}

// Função auxiliar para converter lista para array
function ListaParaArr(node) {
    let arr = [];
    while (node) {
        arr.push(node.val);
        node = node.next;
    }
    return arr;
}

const l1 = arrParaLista([1, 2, 4]);
const l2 = arrParaLista([1, 3, 4]);
const mescla = mesclarListas(l1, l2);

console.log(ListaParaArr(mescla));