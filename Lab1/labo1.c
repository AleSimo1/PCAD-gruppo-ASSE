#include <pthread.h>
#include <assert.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <labo1.h>

const int M = 17;
const int N = 10;
const int P = 15;

int main(){
    int N,M = 10;
	int a[N][M];
		
	printf("\nInseriamo i voti nella matrice \n");
	for(int i=0;i<N-1;i++)
	    for(int j=0;j<M-1;j++) {
		printf("Studente %d \tprova %d: ", i, j);
		scanf("%f", &a[i][j]);
	    }
		
	printf("\nStampiamo i dati \n");
	for (int i=0;i<N;i++) {	
	    printf("\n");
	    for(int j=0;j<M;j++) 
	      printf("\t%7.2f", a[i][j]);				
	}				
}