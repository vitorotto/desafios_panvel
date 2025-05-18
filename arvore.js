const arvore = {
    left: {
        left: undefined,
        right: undefined,
        value: 9
    },
    right: {
        left: {
            left: undefined,
            right: undefined,
            value: 15
        },
        right: {
            left: undefined,
            right: undefined,
            value: 7
        },
        value: 20
    },
    value: 3
}

function saida(arvore) {
    // Se a árvore estiver vazia
    if (!arvore) return []
    const resultado = []
    const fila = [arvore]
    console.log(fila);

    while (fila.length > 0) {
        let tamNivel = fila.length
        const level = []

        for (let i = 0; i < tamNivel; i++) {
            let nodoAtual = fila.shift()
            level.push(nodoAtual.value)

            if (nodoAtual.left) fila.push(nodoAtual.left)
            if (nodoAtual.right) fila.push(nodoAtual.right)
        }
        resultado.push(level)
    }
    return resultado
}

console.log(saida(arvore))