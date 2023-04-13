#include <pthread.h>
#include <time.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

const int M = 17;
const int N = 10;
const int P = 15;

struct matrix {
	int rig;
	int col;
	double *next;
};

struct parameters {
	struct matrix A;
	struct matrix B;
	struct matrix C;
	struct matrix R;			//A*B
	struct matrix result;		//R*C
	int n_thread;	
	int n_block;
};

/*int main(){
	
	// Allocate memory for the matrices
	float **A = (float **)malloc(M*N*sizeof(float *));
	float **B = (float **)malloc(N*P*sizeof(float *));
	float **C = (float **)malloc(P*M*sizeof(float *));
	
	// Initialize the matrices
	for(int i = 0; i < M; i++){
		for(int j = 0; j < N; j++){
			A[i][j] = i+j;
		}
	}
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < P; j++){
			B[i][j] = i+j;
		}
	}
	
	for(int i = 0; i < P; i++){
		for(int j = 0; j < M; j++){
			C[i][j] = i+j;
		}
	}
	
	// Create the threads
	pthread_t threads[M];
	for(int i = 0; i < M; i++){
		pthread_create(&threads[i], NULL, matrixMultiplication, (void *)i);
	}
	
	// Wait for the threads to finish
	for(int i = 0; i < M; i++){
		pthread_join(threads[i], NULL);
	}
	
	// Print the result
	for(int i = 0; i < M; i++){
		for(int j = 0; j < P; j++){
			printf("%f ", C[i][j]);
		}
		printf("*/

void init_matrix(struct matrix *m, int rig, int col){
	m->next = (double*)malloc(rig*col*sizeof(double));

	if(m->next == NULL){
		printf("Error: memory not allocated.");
		exit(-1);
	}

	m->rig = rig;
	m->col = col;
}

void random_matrix(struct matrix *m){
	for(int i = 0; i < m->rig; i++){
		for(int j = 0; j < m->col; j++){
			m->next[i*m->col+j] = rand() % 10;
		}
	}
}

void print_matrix(struct matrix *m){
	for(int i = 0; i < m->rig; i++){
		for(int j = 0; j < m->col; j++){
			printf("%f ", m->next[i*m->col+j]);
		}
		printf("\n");
	}
	printf("\n");
}

void* prod_matrix(void *arg){
	struct parameters *p = (struct parameters*)arg;
	
	for(int i = 0; i < p->A.rig; i++){
		for(int j = 0; j < p->B.col; j++){
			for(int k = 0; k < p->A.col; k++){
				p->R.next[i*p->R.col+j] += p->A.next[i*p->A.col+k] * p->B.next[k*p->B.col+j];
			}
		}
	}
	
	for(int i = 0; i < p->R.rig; i++){
		for(int j = 0; j < p->C.col; j++){
			for(int k = 0; k < p->R.col; k++){
				p->result.next[i*p->result.col+j] += p->R.next[i*p->R.col+k] * p->C.next[k*p->C.col+j];
			}
		}
	}
	
	pthread_exit(NULL);
}

int main(){
	struct parameters *p = (struct parameters*)malloc(sizeof(struct parameters));
	
	init_matrix(&p->A, M, N);
	init_matrix(&p->B, N, P);
	init_matrix(&p->C, P, M);
	init_matrix(&p->R, M, P);
	init_matrix(&p->result, M, P);
	
	random_matrix(&p->A);
	random_matrix(&p->B);
	random_matrix(&p->C);
	
	p->n_thread = 4;
	p->n_block = 4;
	
	pthread_t threads[p->n_thread];
	for(int i = 0; i < p->n_thread; i++){
		pthread_create(&threads[i], NULL, prod_matrix, (void *)p);
	}
	
	for(int i = 0; i < p->n_thread; i++){
		pthread_join(threads[i], NULL);
	}
	
	print_matrix(&p->A);
	print_matrix(&p->B);
	print_matrix(&p->C);
	print_matrix(&p->R);
	print_matrix(&p->result);
	
	return 0;
}