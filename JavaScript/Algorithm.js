
const posX = [];
const posY = [];
const X = 0;
const Y = 1;

const solution = (v) => {
    const ans = [];

    for (const pos of v) {
        if (posX.includes(pos[X])) posX.splice(posX.findIndex(value => value===pos[X]), 1);
        else posX.push(pos[X])

        if (posY.includes(pos[Y])) posY.splice(posY.findIndex(value => value === pos[Y]), 1);
        else posY.push(pos[Y])
    }

    ans.push(posX[0]);
    ans.push(posY[0]);

    return ans;
}


const res = solution([[1, 4], [3, 4], [3, 10]]);
console.log(res);
