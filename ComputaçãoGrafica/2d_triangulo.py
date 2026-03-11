import pygame  # Importa a biblioteca Pygame para gerenciar gráficos e entrada do usuário
from pygame.locals import *  # Importa constantes do Pygame para eventos de teclado e mouse
from OpenGL.GL import *  # Importa funções do OpenGL para renderização gráfica
from OpenGL.GLU import *  # Importa GLU para operações gráficas auxiliares

# -----------------------------
# Variáveis de posição e rotação do Triângulo 1
# -----------------------------
x = -3  # Posição inicial no eixo X
y = 0   # Posição inicial no eixo Y
z = -10 # Posição inicial no eixo Z (zoom)
r = 0   # Ângulo de rotação do triângulo

# -----------------------------
# Variáveis de posição e rotação do Triângulo 2
# -----------------------------
x2 = 0   # Posição inicial no eixo X
y2 = 0   # Posição inicial no eixo Y
z2 = -10 # Posição inicial no eixo Z (zoom)
r2 = 2   # Ângulo de rotação do triângulo

# -----------------------------
# Variáveis de posição e rotação do Triângulo 3
# -----------------------------
x3 = 3   # Posição inicial no eixo X
y3 = 0   # Posição inicial no eixo Y
z3 = -10 # Posição inicial no eixo Z (zoom)
r3 = 1   # Ângulo de rotação do triângulo

# -----------------------------
# Variáveis de escala (igual para todos os triângulos)
# -----------------------------
ex = 1  # Escala no eixo X
ey = 1  # Escala no eixo Y
ez = 1  # Escala no eixo Z (não afeta 2D)

# -----------------------------
# Função de inicialização do OpenGL
# -----------------------------
def init():
    glClearColor(1, 1, 1, 1)  # Define a cor de fundo branca
    glEnable(GL_DEPTH_TEST)   # Habilita o teste de profundidade

    # Configura a matriz de projeção
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    gluPerspective(45, 800/600, 0.1, 100)  # Campo de visão, proporção, near e far

    # Retorna à matriz de modelagem
    glMatrixMode(GL_MODELVIEW)

# -----------------------------
# Função para desenhar os triângulos
# -----------------------------
def draw():

    # -----------------------------
    # Desenha Triângulo 1 (PRETO)
    # -----------------------------
    glLoadIdentity()  # Reinicia a matriz de transformações
    glTranslatef(x, y, z)  # Aplica translação do Triângulo 1
    glRotatef(r, 1, 1, 0)  # Aplica rotação do Triângulo 1

    glBegin(GL_TRIANGLES)  # Início da definição do triângulo
    glColor3f(0, 0, 0)    # Cor preta
    glVertex3f(0, 2, 0)   # Vértice superior
    glVertex3f(-2, -2, 0) # Vértice inferior esquerdo
    glVertex3f(2, -2, 0)  # Vértice inferior direito
    glEnd()               # Fim do triângulo

    # -----------------------------
    # Desenha Triângulo 2 (VERMELHO)
    # -----------------------------
    glLoadIdentity()  # Reinicia a matriz para independência
    glTranslatef(x2, y2, z2)  # Aplica translação do Triângulo 2
    glRotatef(r2, 1, 1, 0)    # Aplica rotação do Triângulo 2

    glBegin(GL_TRIANGLES)
    glColor3f(1, 0, 0)    # Cor vermelha
    glVertex3f(0, 2, 0)
    glVertex3f(-2, -2, 0)
    glVertex3f(2, -2, 0)
    glEnd()

    # -----------------------------
    # Desenha Triângulo 3 (AZUL)
    # -----------------------------
    glLoadIdentity()  # Reinicia a matriz para independência
    glTranslatef(x3, y3, z3)  # Aplica translação do Triângulo 3
    glRotatef(r3, 1, 1, 0)    # Aplica rotação do Triângulo 3

    glBegin(GL_TRIANGLES)
    glColor3f(0, 0, 1)    # Cor azul
    glVertex3f(0, 2, 0)
    glVertex3f(-2, -2, 0)
    glVertex3f(2, -2, 0)
    glEnd()

# -----------------------------
# Função principal do programa
# -----------------------------
def main():

    pygame.init()  # Inicializa o Pygame
    pygame.display.set_mode((800, 600), DOUBLEBUF | OPENGL)  # Janela maior
    init()  # Inicializa o OpenGL

    # Declaração das variáveis globais
    global x, y, z, r
    global x2, y2, z2, r2
    global x3, y3, z3, r3

    running = True

    while running:

        for event in pygame.event.get():
            if event.type == pygame.QUIT:  # Fecha o programa
                running = False

            if event.type == KEYDOWN:  # Captura tecla pressionada

                # -----------------------------
                # Triângulo 1 (PRETO) - Teclas WASD + Z/X (zoom)
                # -----------------------------
                if event.key == K_a:
                    x -= 0.3
                if event.key == K_d:
                    x += 0.3
                if event.key == K_w:
                    y += 0.3
                if event.key == K_s:
                    y -= 0.3
                if event.key == K_z:
                    z += 0.5  # aproxima
                if event.key == K_x:
                    z -= 0.5  # afasta

                # -----------------------------
                # Triângulo 2 (VERMELHO) - Teclas IJKL + C/V (zoom)
                # -----------------------------
                if event.key == K_j:
                    x2 -= 0.3
                if event.key == K_l:
                    x2 += 0.3
                if event.key == K_i:
                    y2 += 0.3
                if event.key == K_k:
                    y2 -= 0.3
                if event.key == K_c:
                    z2 += 0.5  # aproxima
                if event.key == K_v:
                    z2 -= 0.5  # afasta

                # -----------------------------
                # Triângulo 3 (AZUL) - Teclas TGFH
                # -----------------------------
                if event.key == K_f:
                    x3 -= 0.3
                if event.key == K_h:
                    x3 += 0.3
                if event.key == K_t:
                    y3 += 0.3
                if event.key == K_g:
                    y3 -= 0.3

        # -----------------------------
        # Limpa a tela antes de desenhar
        # -----------------------------
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

        # -----------------------------
        # Desenha todos os triângulos
        # -----------------------------
        draw()

        # -----------------------------
        # Atualiza a tela
        # -----------------------------
        pygame.display.flip()
        pygame.time.wait(10)

        # -----------------------------
        # Atualiza ângulos de rotação independentes
        # -----------------------------
        r += 3
        r2 += 2
        r3 += 4

    pygame.quit()  # Encerra o Pygame

# -----------------------------
# Executa o programa
# -----------------------------
if __name__ == "__main__":
    main()
