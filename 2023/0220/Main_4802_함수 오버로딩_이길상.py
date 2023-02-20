import sys
input = sys.stdin.readline
write = sys.stdout.write

FUNCTIONS = dict()
RECORD = []


def parse_declaration_line(line):
    words = line.split()

    name = words[0]
    params = words[2:-1]
    rettype = words[-1]

    if name not in FUNCTIONS:
        FUNCTIONS[name] = dict()
        FUNCTIONS[name]['#'] = 0
    
    FUNCTIONS[name]['#'] += 1
    
    node = FUNCTIONS[name]
    for param in params:
        if param not in node:
            node[param] = dict()
        node = node[param]
    
    if '*' not in node:
        node['*'] = dict()
    node['*'][rettype] = FUNCTIONS[name]['#']


def check_call_line(line):
    RECORD.clear()

    function_call = line.split(' = ', 1)
    data_type = function_call[0]
    right_hand_side = function_call[1]
    
    types, _ = parse_function(right_hand_side.split(), 0)

    if data_type in types:
        if len(types)>1:
            write('ambiguous ' + str(len(types)) + '\n')
        else:
            write(data_type + " = ")

    else:
        write('impossible\n')


def parse_function(words, idx):
    fname = words[idx]
    num_params = int(words[idx+1])
    param_list = []

    idx+=2
    for _ in range(num_params):
        data_types, idx = parse_param(words, idx)
        param_list.append(data_types)

    node = FUNCTIONS[fname]
    possible_types = dict()
    param_type_matching(node, param_list, 0, possible_types)
    
    return possible_types, idx


def parse_param(words, idx):
    identifier = words[idx]
    if identifier.isupper():
        return [identifier], idx+1
    else:
        possible_types, idx = parse_function(words, idx)
        return list(possible_types.keys()), idx


def param_type_matching(node, param_list, idx, result):
    if idx == len(param_list):
        if '*' in node:
            result.update(node['*'])
        return
    for dtype in param_list[idx]:
        if dtype in node:
           param_type_matching(node[dtype], param_list, idx+1, result)

line = input()
while (line != '#\n'):
    parse_declaration_line(line)
    line = input()

line = input()
while (line != '#\n'):
    check_call_line(line)
    line = input()
 
