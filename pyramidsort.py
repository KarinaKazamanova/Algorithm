

def pyramidsort(list_of_values: list[int]):
    sorted_list_of_values = []
    for i in list_of_values:
        sorted_list_of_values.append(i)
       
        for i in range(len(sorted_list_of_values)):
            index = i
            while index !=0:
                parent_index = (index - 1) // 2
                if sorted_list_of_values[index] <= sorted_list_of_values[parent_index]:
                    break
                else:
                    sorted_list_of_values[index], sorted_list_of_values[parent_index] = sorted_list_of_values[parent_index], sorted_list_of_values[index]
                
                index = parent_index

    return sorted_list_of_values



list_new = [1, 2,  3, 4, 5, 6, 7, 8, 9, 10, 11,12]

sorted_list = pyramidsort(list_new)

print(sorted_list)
