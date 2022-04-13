
class MovingAverage {
    constructor (size) {
        this._size = size
        this._values = []
    }

    next (val) {
        this._values.push(val)

        const sampleSet = this._values.slice(-this._size)
        const average = sampleSet.reduce(sum) / Math.min(sampleSet.length, this._size)

        return average
    }
}

function sum (a, b) {
    return a + b
}
