// C Program for Message Queue (Reader Process)
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/msg.h>

// structure for message queue
struct mesg_buffer {
  long mesg_type;
  char mesg_text[100000];
} message;

int main() {

  int msgid;

  // msgget creates a message queue
  // and returns identifier
  msgid = msgget(225200, 0666 | IPC_CREAT);

  // msgrcv to receive message
  msgrcv(msgid, &message, sizeof(message), 1, 0);

  // display the message
  // printf("Data Received is : %s \n", message.mesg_text);

  FILE *f = fopen("test.html", "w");
  if (f == NULL) {
    printf("Error opening file!\n");
    exit(1);
  }

  fprintf(f, "%s", message.mesg_text);

  fclose(f);

  // to destroy the message queue
  msgctl(msgid, IPC_RMID, NULL);

  return 0;
}
