# -*- coding: utf-8 -*-

import numpy as np
import pandas as pd
import operator
def distance(x1,x2):
    return np.sum(np.square(x1-x2))
x1=np.array([[1,1],[2,2],[3,3],[4,4],[5,5]])
x2=np.array([[6,6],[7,7]])
y1=np.array([0,0,0,1,1])   
y_predict=[]
def vote(x,y1):
    count_dic=dict()
    #print(y1)
    for item in y1:
        if item in count_dic:
            count_dic[item]+=1
        else:
            count_dic[item]=1
    sorted_vote_dict=sorted(count_dic.items(),key=operator.itemgetter(1),reverse=True)
    print(sorted_vote_dict)
    return sorted_vote_dict[0][0]
for i in range(len(x2)):
    dis=[distance(x2[i],x1[j]) for j in range(len(x1))]
    print(dis)
    sorted_dis=np.argsort(dis)#分别表示与几个坐标点距离最近
    top_k_index=sorted_dis[:3]
    y_predict.append(vote(top_k_index,y1[top_k_index]))   

print(y_predict)