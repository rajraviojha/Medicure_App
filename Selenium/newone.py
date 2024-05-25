import unittest
import os
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

chrome_options = Options()
chrome_options.add_argument("--headless")  # Uncomment this line to run in headless mode
chrome_options.add_argument("--start-maximized")

class TestFlaskApp(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome(options=chrome_options)
        self.driver.implicitly_wait(10)
        self.driver.get("http://localhost:8082/")

    def tearDown(self):
        self.driver.quit()

    def take_screenshot(self, filename):
        screenshot_dir = r"/var/lib/jenkins/workspace/java/"  # Use a raw string
        if not os.path.exists(screenshot_dir):
            os.makedirs(screenshot_dir)
        self.driver.save_screenshot(os.path.join(screenshot_dir, filename))

    def test_add_task(self):
        print("Adding tasks...")
        # Find the input fields for adding a task
        name_field = self.driver.find_element(By.ID, "Your Name")  # Corrected ID
        name_field.send_keys("John Doe")
        phone_field = self.driver.find_element(By.ID, "Phone Number")  # Corrected variable name
        phone_field.send_keys("1234567890")  # Example phone number
        email_field = self.driver.find_element(By.ID, "Email")  # Corrected ID
        email_field.send_keys("john.doe@example.com")  # Example email
        message_field = self.driver.find_element(By.ID, "Message")  # Corrected ID
        message_field.send_keys("This is a test message.")  # Example message

        # Find and click the submit button
        submit_button = self.driver.find_element(By.XPATH, "/html/body/section[4]/div/div[2]/div[1]/div/form/div[4]/button")  # Corrected XPath
        submit_button.click()

        # Check if success message or element is present
        success_element = self.driver.find_elements(By.CLASS_NAME, "success-message")
        if success_element:
            print("Submission successful. Taking screenshot...")
            # Take screenshot after successful submission
            self.take_screenshot("task_submission_success.png")
        else:
            print("Submission failed. No screenshot taken.")
        

        # Take screenshot after submission
        self.take_screenshot("task_submission.png")

if __name__ == "__main__":
    unittest.main()
