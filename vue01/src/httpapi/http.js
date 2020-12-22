import axios from 'axios';

axios.defaults.baseURL = process.env.API_ROOT

/**
 * 封装get方法
 * @param url
 * @returns {Promise}
 */
export function get(url) {
    return new Promise((resolve, reject) => {
        axios({
            method: "get",
            url: url,
            headers: {
                token: sessionStorage.getItem("token")
            }
        })
            .then(response => {
                resolve(response.data);
            })
            .catch(err => {
                reject(err)
            })
    })
}

/**
* 封装post请求
* @param url
* @param data
* @returns {Promise}
*/
export function post(url, data = {}) {
    return new Promise((resolve, reject) => {
        axios({
            method: "post",
            url: url,
            data: data,
            headers: {
                token: sessionStorage.getItem("token")
            }
        }).then(response => {
            resolve(response.data);
        }, err => {
            reject(err)
        })
    })
}

/**
* 封装post请求
* @param url
* @param data
* @returns {Promise}
*/
export function Login(url, data = {}) {
    return new Promise((resolve, reject) => {
        axios({
            method: "post",
            url: url,
            data: data
        }).then(response => {
            resolve(response.data);
        }, err => {
            reject(err)
        })
    })
}