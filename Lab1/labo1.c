#include<stdio.h>
int main(){
    int N,M = 10;
	float a[N][M];
	int i,j;
		
	printf("\nInseriamo i voti nella matrice \n");
	for(i=0;i<N-1;i++)
	    for(j=0;j<M-1;j++) {
		printf("Studente %d \tprova %d: ", i, j);
		scanf("%f", &a[i][j]);
	    }
				
	printf("\nCalcolo media delle prove \n");
	for(j=0;j<M;j++) {
	    a[N-1][j]=0;
	    for(i=0;i<N-1;i++)
	       a[N-1][j]=a[N-1][j]+a[i][j];
	    a[N-1][j]=a[N-1][j]/(N-1);
	}
		
	printf("\nCalcolo media studente \n");
	for(i=0;i<N-1;i++){
	     a[i][M-1]=0;
	     for(j=0;j<M-1;j++) 
		a[i][M-1]=a[i][M-1]+a[i][j];
	     a[i][M-1]=a[i][M-1]/(M-1);
	}
		
	printf("\nStampiamo i dati \n");
	for (i=0;i<N;i++) {	
	    printf("\n");
	    for(j=0;j<M;j++) 
	      printf("\t%7.2f", a[i][j]);				
	}				
}