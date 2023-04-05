#include <pthread.h>
#include <time.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

void creo_matrice(int rig, int col, float ** matrice);
void stampa_matrice(int rig, int col, float ** matrice);

int main(){
    float M, N, P = 10;
	float ** matrice;
	creo_matrice(M, N, matrice);
	stampa_matrice(M, N, matrice);
}

void creo_matrice(int rig, int col, float ** matrice){
	int i, j;
	matrice = (float **)malloc(rig * sizeof(float *));
	for (i = 0; i < rig; i++){
		matrice[i] = (float *)malloc(col * sizeof(float));
	}
	for (i = 0; i < rig; i++){
		for (j = 0; j < col; j++) 
			matrice[i][j] = i+j;
	}
}

void stampa_matrice(int rig, int col, float ** matrice){
	int i, j;
	for (i = 0; i < rig; i++){
		for (j = 0; j < col; j++) 
			printf("%f", matrice[i][j]);
		printf("\n");
	}
}