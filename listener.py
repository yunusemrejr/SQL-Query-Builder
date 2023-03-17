from commandspicker import *
from queryengine import *

def listener():
  input1 = input("\nType here: ") 
  cp=commandspicker(input1)
  if cp=="-ex":
        listener()
        return
  if cp=="-format":
       listener()
       return
   
  else:
      queryengine(input1)
      return
     