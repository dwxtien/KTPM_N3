using BaiTap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using System.Web.UI.WebControls;

namespace BaiTap.Controllers
{
    public class TaiKhoanController : Controller
    {
        private Model1 db = new Model1();
        
        [HttpGet]
        public ActionResult Login() { 
            
            return View();
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(account_user accountuser)
        {
            try
            {
                System.Diagnostics.Debug.WriteLine("Login attempt: " + accountuser.username);

                // Check if the database connection is valid
                var testConnection = db.account_user.FirstOrDefault();
                if (testConnection == null)
                {
                    ViewBag.loginFail = "Database connection issue.";
                    return View("Login");
                }

                // Validate the user credentials
                var userName = accountuser.username;
                var PassWord = accountuser.password;
                var check = db.account_user.FirstOrDefault(acc => acc.username.Equals(userName, StringComparison.OrdinalIgnoreCase) && acc.password.Equals(PassWord, StringComparison.OrdinalIgnoreCase));
                    
                if (check != null)
                {
                    // Set a session or a persistent cookie based on RememberMe
                    if (accountuser.RememberMe)
                    {
                        HttpCookie authCookie = new HttpCookie("AuthCookie")
                        {
                            Value = userName,
                            Expires = DateTime.Now.AddDays(1)
                        };
                        Response.Cookies.Add(authCookie);
                    }
                    else
                    {
                        Session["account_user"] = check;
                    }

                    return RedirectToAction("SanPham", "QuanLySanPham");
                }
                else
                {
                    ViewBag.loginFail = "Sai tài khoản hoặc mật khẩu";
                    return View("Login");
                }
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine("Error: " + ex.Message);
                System.Diagnostics.Debug.WriteLine("Stack Trace: " + ex.StackTrace);

                ViewBag.loginFail = "An error occurred while processing your request.";
                return View("Login");
            }

        }
        [HttpPost]
        public ActionResult Signout()
        {
            Session["account_user"] = null;
            FormsAuthentication.SignOut();
            return RedirectToAction("Login", "TaiKhoan");
        }

        public ActionResult Signin()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Signin(account_user newAccount)
        {
            if (ModelState.IsValid)
            {
                var existingUser = db.account_user.FirstOrDefault(u => u.username.Equals(newAccount.username, StringComparison.OrdinalIgnoreCase));
                if (existingUser != null)
                {
                    ModelState.AddModelError("", "Tài khoản đã tồn tại!");
                }
                else
                {
                    db.account_user.Add(newAccount);
                    db.SaveChanges();
                    return RedirectToAction("Login");
                }
            }
            return View(newAccount);
        }
    





    // GET: TaiKhoan
    public ActionResult Index()
        {
            return View();
        }
        public ActionResult DangKy()
        {
            return View();
        }
        [HttpPost]
        public ActionResult DangKy(Admin admins)
        {
            return View();
        }
        public ActionResult DangNhap()
        {
            return View();
        }
        [HttpPost]
        public ActionResult DangNhap(Admin admins)
        {
            return View();
        }
    }
}