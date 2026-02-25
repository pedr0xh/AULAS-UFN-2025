import math

print('='*40)
print('      CALCULADORA DE VETORES 3D')
print('='*40)

x = float(input('Valor de x: '))
y = float(input('Valor de y: '))
z = float(input('Valor de z: '))

def tamanhoVetor(x, y, z):
    return math.sqrt(x**2 + y**2 + z**2)

while True:
    print('\n' + '='*40)
    print('                MENU')
    print('='*40)
    print('[1] Calcular o tamanho do vetor')
    print('[2] Normalizar o vetor')
    print('[3] Adicionar outro vetor')
    print('[4] Subtrair outro vetor')
    print('[5] Multiplicar por um escalar')
    print('[6] Dividir por um escalar')
    print('[7] Produto escalar com outro vetor')
    print('[8] Sair')
    print('='*40)

    opcao = int(input('Escolha uma opção: '))
    print('='*40)

    if opcao == 1:
        tamanho = tamanhoVetor(x, y, z)
        print('📏 Tamanho do vetor:', round(tamanho, 2))

    elif opcao == 2:
        tamanho = tamanhoVetor(x, y, z)
        if tamanho != 0:
            print('🔄 Vetor normalizado:')
            print(f'x: {round(x/tamanho,2)}')
            print(f'y: {round(y/tamanho,2)}')
            print(f'z: {round(z/tamanho,2)}')
        else:
            print('❌ Não é possível normalizar um vetor nulo!')

    elif opcao == 3:
        print('\n--- Novo Vetor ---')
        x2 = float(input('Valor de x: '))
        y2 = float(input('Valor de y: '))
        z2 = float(input('Valor de z: '))

        print('\nResultado da soma:')
        print(f'x: {x + x2}')
        print(f'y: {y + y2}')
        print(f'z: {z + z2}')

    elif opcao == 4:
        print('\n--- Novo Vetor ---')
        x2 = float(input('Valor de x: '))
        y2 = float(input('Valor de y: '))
        z2 = float(input('Valor de z: '))

        print('\nResultado da subtração:')
        print(f'x: {x - x2}')
        print(f'y: {y - y2}')
        print(f'z: {z - z2}')

    elif opcao == 5:
        escalar = float(input('Digite o valor do escalar: '))
        print('\nResultado da multiplicação:')
        print(f'x: {x * escalar}')
        print(f'y: {y * escalar}')
        print(f'z: {z * escalar}')

    elif opcao == 6:
        escalar = float(input('Digite o valor do escalar: '))
        if escalar != 0:
            print('\nResultado da divisão:')
            print(f'x: {x / escalar}')
            print(f'y: {y / escalar}')
            print(f'z: {z / escalar}')
        else:
            print('❌ Não é possível dividir por zero!')

    elif opcao == 7:
        print('\n--- Novo Vetor ---')
        x2 = float(input('Valor de x: '))
        y2 = float(input('Valor de y: '))
        z2 = float(input('Valor de z: '))

        produto = x*x2 + y*y2 + z*z2
        print('\n📌 Produto escalar:', produto)

    elif opcao == 8:
        print('🔚 Encerrando programa...')
        break

    else:
        print('❌ Digite uma opção válida!')
