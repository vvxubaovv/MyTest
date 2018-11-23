import copy

answer_save=list()
cache_map=dict()

def h(numb,answer_list):
    if containt(numb):
        answer_list.append([numb])
    for i in range(1,int(numb/2)):
        x1,x2=i,numb-i
        if above(x1) or above(x2):
            return
        l=get_not_containt((x1,x2))
        if is_all_diff((x1,x2)) and len(l)==0:
            answer_list.append([x1,x2])

        x1_list = cache_map.get(x1)
        x2_list = cache_map.get(x2)
        if x1_list is None:
            x1_list=list()
            h(x1,x1_list)
        if x2_list is None:
            x2_list=list()
            h(x2,x2_list)
        temp = list()
        for x1_a in x1_list:
            for x2_a in x2_list:
                tt = copy.deepcopy(x1_a)
                for t in x2_a:
                    tt.append(t)
                temp.append(tt)
        #print("jjj"+str(temp))

        for an in temp:
            l=get_not_containt(an)
            if is_all_diff(an) and len(l)==0:
                answer_list.append(an)
    #print(str(answer_list))
    temp=remove_replace(answer_list)
    cache_map[numb]=temp
    return temp


def split(numb):
    return numb-1,1

def is_all_diff(answer):
    s=set()
    for a in answer:
        old_len=len(s)
        s.add(a)
        new_len=len(s)
        if old_len==new_len:
            return False
    return True

def get_not_containt(answer):
    l=list()
    for a in answer:
        if not containt(a):
            l.append(a)
    return l

limit_list=[1,2,3,4,5,6,7,8,9,10,11,12,13,]
def containt(numb):
    try:
        limit_list.index(numb)
    except ValueError as e:
        return False
    return True

def beyong(numb):
    return numb>13
def above(numb):
    return numb<1

def remove_replace(answer_list):
    for answer in answer_list:
        answer.sort()
    del_last=set()
    for x in range(len(answer_list)):
        if(x>=len(answer_list)-1):
                break;
        for y in range(x+1,len(answer_list)):
            if len(answer_list[x]) != len(answer_list[y]):
                continue
            else:
                b=True
                for i in range(len(answer_list[x])):
                    if answer_list[x][i]!=answer_list[y][i]:
                        b=False
                        break
                if b:
                    del_last.add(y)
    #print("fffff"+str(del_last))
    x=0;
    temp = list()
    for d in range(len(answer_list)):
        try:
            del_last.remove(d)
        except KeyError:
            temp.append(answer_list[d])
    return temp

if __name__=="__main__":
    an_list = list()
    h(7,an_list)
    print(str(an_list))
    temp=remove_replace(an_list)
    print("------------------------------------")
    print(temp)
    print(len(temp))
