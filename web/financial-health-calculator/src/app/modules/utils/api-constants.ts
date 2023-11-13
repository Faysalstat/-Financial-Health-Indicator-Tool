const BASE_URL = "http://localhost:8000";


export const AuthenticationUrls = {
  LOGIN : BASE_URL + "/auth/login",
  SIGN_OUT : BASE_URL + "/auth/signout",
  ADD_USER: BASE_URL + "/auth/signup",
  CHECK_IS_LOGGEDIN: BASE_URL + "/auth/islogedin"
}

export const FinanceServiceUrls = {
  SAVE_FINACE_RECORD : BASE_URL + "/health/api/save",
  FETCH_ALL_FINACE_RECORD : BASE_URL + "/health/api/getall",

}