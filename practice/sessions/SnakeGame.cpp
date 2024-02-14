#include <iostream>
#include <cstdlib>
#include <ctime>
#include <unistd.h>
#include <termios.h>

using namespace std;

const int width = 20;
const int height = 10;

enum Direction { UP, DOWN, LEFT, RIGHT };

struct Point {
    int x, y;
};

class SnakeGame {
private:
    Point snake[100];
    Point fruit;
    int length;
    Direction dir;
    bool gameOver;

    char getch() {
        char buf = 0;
        struct termios old = {0};
        if (tcgetattr(0, &old) < 0)
            perror("tcsetattr()");
        old.c_lflag &= ~ICANON;
        old.c_lflag &= ~ECHO;
        old.c_cc[VMIN] = 1;
        old.c_cc[VTIME] = 0;
        if (tcsetattr(0, TCSANOW, &old) < 0)
            perror("tcsetattr ICANON");
        if (read(0, &buf, 1) < 0)
            perror("read()");
        old.c_lflag |= ICANON;
        old.c_lflag |= ECHO;
        if (tcsetattr(0, TCSADRAIN, &old) < 0)
            perror("tcsetattr ~ICANON");
        return (buf);
    }

    void gotoxy(int x, int y) {
        printf("\033[%d;%dH", y, x);
    }

    void generateFruit() {
        srand(time(NULL));
        fruit.x = rand() % width + 1;
        fruit.y = rand() % height + 1;
    }

public:
    SnakeGame() {
        length = 1;
        snake[0].x = width / 2;
        snake[0].y = height / 2;
        dir = RIGHT;
        gameOver = false;
        generateFruit();
    }

    void draw() {
        system("clear");
        for (int i = 0; i < width + 2; i++)
            cout << "#";
        cout << endl;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j == 0)
                    cout << "#";
                if (i == fruit.y && j == fruit.x)
                    cout << "F";
                else if (i == snake[0].y && j == snake[0].x)
                    cout << "O";
                else {
                    bool print = false;
                    for (int k = 1; k < length; k++) {
                        if (snake[k].x == j && snake[k].y == i) {
                            cout << "o";
                            print = true;
                        }
                    }
                    if (!print)
                        cout << " ";
                }

                if (j == width - 1)
                    cout << "#";
            }
            cout << endl;
        }

        for (int i = 0; i < width + 2; i++)
            cout << "#";
        cout << endl;
        cout << "Score:" << length - 1 << endl;
    }

    void input() {
        char key = getch();
        switch (key) {
            case 'w':
                dir = UP;
                break;
            case 's':
                dir = DOWN;
                break;
            case 'a':
                dir = LEFT;
                break;
            case 'd':
                dir = RIGHT;
                break;
            case 'x':
                gameOver = true;
                break;
        }
    }

    void move() {
        Point prev = snake[0];
        Point temp, prev2;
        snake[0] = {snake[0].x + (dir == RIGHT) - (dir == LEFT), snake[0].y + (dir == DOWN) - (dir == UP)};
        for (int i = 1; i < length; i++) {
            temp = snake[i];
            snake[i] = prev;
            prev = temp;
        }

        if (snake[0].x == fruit.x && snake[0].y == fruit.y) {
            length++;
            generateFruit();
        }

        if (snake[0].x <= 0 || snake[0].x >= width || snake[0].y <= 0 || snake[0].y >= height)
            gameOver = true;

        for (int i = 1; i < length; i++) {
            if (snake[0].x == snake[i].x && snake[0].y == snake[i].y)
                gameOver = true;
        }
    }

    bool isGameOver() {
        return gameOver;
    }
    int getLength(){
        return length;
    }
};

int main() {
    SnakeGame game;

    while (!game.isGameOver()) {
        game.draw();
        game.input();
        game.move();
        usleep(1000);
    }

    cout << "Game Over! Your score: " << game.getLength() << endl;

    return 0;
}
